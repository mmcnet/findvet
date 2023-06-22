package br.com.findvet.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.SolicitacaoConsultaDto;
import br.com.findvet.controller.form.SolicitacaoConsultaForm;
import br.com.findvet.modelo.Animal;
import br.com.findvet.modelo.Cliente;
import br.com.findvet.modelo.Consulta;
import br.com.findvet.modelo.Parceiro;
import br.com.findvet.modelo.SolicitacaoConsulta;
import br.com.findvet.modelo.TipoDeConsulta;
import br.com.findvet.repository.SolicitacaoConsultaRepository;
@Service
public class SolicitacaoConsultaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SolicitacaoConsultaRepository repository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ParceiroService parceiroService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private ConsultaService consultaService;
	
	public List<SolicitacaoConsultaDto> listarSolicitacaoPorCliente(Long id){
		List<SolicitacaoConsulta> solicitacoes = repository.findSolicitacaoByCliente(id);
		return SolicitacaoConsultaDto.converter(solicitacoes);
	}
	
	public ResponseEntity<?> cadastrar(SolicitacaoConsultaForm form) {
		SolicitacaoConsulta solicitacao = form.converter();
		Cliente cliente = clienteService.listaClientePorId(form.getCliente_id());
		Animal animal = animalService.listaAnimalPorId(form.getAnimal_id());
		Parceiro parceiro = parceiroService.listaParceirosPorId(form.getParceiro_id());
		if(cliente!=null && parceiro!=null && animal!=null) {
			if(solicitacao!=null) {
				solicitacao.setCliente(cliente);
				solicitacao.setAnimal(animal);				
				solicitacao.setParceiro(parceiro);
				solicitacao.setValorEstimado(parceiro.getValor());
				aberta(solicitacao);
				repository.save(solicitacao);
				return ResponseEntity.ok().build();
			}
			else {
				 return ResponseEntity.notFound().build();
			}
		}
		 return ResponseEntity.notFound().build();
		
	}
	public SolicitacaoConsulta buscarSolicitracaoConsulta (Long id) {
		SolicitacaoConsulta consulta = repository.findSolicitacaoById(id);
	    if(consulta!=null) {
	    	 return consulta;
	    }
	     return null;
	}

	private void updateStatusConsulta(SolicitacaoConsulta solicitacao) {
		repository.save(solicitacao);
	}
	public void aberta(SolicitacaoConsulta solicitacao) {
		//SolicitacaoConsulta solicitacao = buscarSolicitracaoConsulta(id);
		solicitacao.aberta();
		updateStatusConsulta(solicitacao);
		
	}
	public void aprovada(SolicitacaoConsulta solicitacao) {
		//SolicitacaoConsulta solicitacao = buscarSolicitracaoConsulta(id);
		solicitacao.aprovada();
		updateStatusConsulta(solicitacao);
		gerarConsulta(solicitacao);
	}
	
	public void cancelada(SolicitacaoConsulta solicitacao) {
		//SolicitacaoConsulta solicitacao = buscarSolicitracaoConsulta(id);
		solicitacao.cancelada();
		updateStatusConsulta(solicitacao);
	}
	
	public ResponseEntity<?> gerarConsulta(SolicitacaoConsulta solicitacao) {
		if(solicitacao!=null) {
			carregarConsulta(solicitacao);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	protected void carregarConsulta(SolicitacaoConsulta solicitacao) {
		Consulta consulta = new Consulta();
		consulta.setAnimal(solicitacao.getAnimal());
		consulta.setCliente(solicitacao.getCliente());
		consulta.setDataDaConsulta(solicitacao.getDataDaConsulta());
		consulta.setHoraDaConsulta(solicitacao.getHoraDaConsulta());
		consulta.setParceiro(solicitacao.getParceiro());
		consulta.setSintoma(solicitacao.getSintoma());
		consulta.setStatus(consulta.getStatus().ABERTA);
		consulta.setTipoDeConsulta(TipoDeConsulta.AGENDADA);
		consulta.setValor(solicitacao.getValorEstimado());
		consultaService.gerarConsulta(consulta);
	}
	
}
