package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.ParceiroDto;
import br.com.findvet.controller.form.ParceiroForm;
import br.com.findvet.controller.form.UpdateParceiroForm;
import br.com.findvet.modelo.Parceiro;
import br.com.findvet.modelo.ParceiroPessoaFisica;
import br.com.findvet.modelo.StatusDoParceiro;
import br.com.findvet.modelo.Telefone;
import br.com.findvet.repository.ParceiroPessoaFisicaRepository;
import br.com.findvet.security.EncodedSha1;

@Service
public class ParceiroService {
	
	@Autowired
	private ParceiroPessoaFisicaRepository parceiroRepository;
	@Autowired
	private TelefoneService telefoneService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private PerfilService perfilService;

	
	private StatusDoParceiro status;

	public StatusDoParceiro getStatus() {
		return status;
	}

	public List<ParceiroDto> listaTodosParceiros(){
		List<ParceiroPessoaFisica> clientes = parceiroRepository.findAll();
		return ParceiroDto.converter(clientes);
	}
	
	public ParceiroDto listaParceirosPorCpf(String cpf){
		ParceiroPessoaFisica parceiro = parceiroRepository.findByCpf(cpf);
		return ParceiroDto.converter(parceiro);
	}
	
	public ParceiroPessoaFisica listaParceirosPorId(Long id){
		ParceiroPessoaFisica parceiro = parceiroRepository.findParceiroId(id);
		return parceiro;
	}
	
	public ResponseEntity<?> cadastrar(ParceiroForm form) {
		ParceiroPessoaFisica parceiro = (ParceiroPessoaFisica) form.converter();
		parceiro.setSenha(new EncodedSha1().encode(parceiro.getSenha()));
		parceiro.setPerfis(perfilService.localizarPerfilPorNome("PARCEIRO"));
		parceiroRepository.save(parceiro);
		parceiro = parceiroRepository.findByNome(parceiro.getNome());
		if(parceiro!=null) {
			if(!form.getTelefones().isEmpty()){
				setTelefoneParceiro(form.getTelefones(),parceiro);
			}
			if(form.getEndereco()!=null) {
				enderecoService.incluirEndereco(form.getEndereco(),parceiro);
			}
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public void setTelefoneParceiro(List<Telefone> telefones, Parceiro parceiro) {
		telefoneService.setTelefone(telefones,  parceiro);
	}
	
	public ParceiroPessoaFisica listaPartceiroPorCpf(String cpf){
		return parceiroRepository.findByCpf(cpf);
	}
	public ResponseEntity<?> remover(Long id){
		
		if(parceiroRepository.findParceiroId(id)!=null) {
			parceiroRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<ParceiroDto> atualizar(String cpf, UpdateParceiroForm form) {
		ParceiroDto parceiroDto= form.atualizar(cpf, parceiroRepository);
		 if(parceiroDto!=null) {
			 return ResponseEntity.ok(parceiroDto);
		 }
		 return ResponseEntity.notFound().build();
	}
	
	public ParceiroPessoaFisica buscarParceiro (String email) {
		ParceiroPessoaFisica parceiro = parceiroRepository.findByEmail(email);
	    if(parceiro!=null) {
	    	 return parceiro;
	    }
	     return null;
	}
	public void disponivel(String email) {
		ParceiroPessoaFisica parceiro = buscarParceiro(email);
		parceiro.disponivel();
		updateStatusParceiro(parceiro);
		
	}

	private void updateStatusParceiro(ParceiroPessoaFisica parceiro) {
		parceiroRepository.save(parceiro);
	}
	public void ocupado(String email) {
		ParceiroPessoaFisica parceiro = buscarParceiro(email);
		parceiro.ocupado();
		updateStatusParceiro(parceiro);
	}
	public void solicitado(String email) {
		ParceiroPessoaFisica parceiro = buscarParceiro(email);
		parceiro.solicitado();
		updateStatusParceiro(parceiro);
	}
	public void indisponivel(String email) {
		ParceiroPessoaFisica parceiro = buscarParceiro(email);
		parceiro.indisponivel();
		updateStatusParceiro(parceiro);
	}
	
}
