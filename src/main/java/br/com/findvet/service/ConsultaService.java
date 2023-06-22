package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.ConsultaDto;
import br.com.findvet.controller.form.ConsultaForm;
import br.com.findvet.controller.form.UpdateConsultaForm;
import br.com.findvet.modelo.Animal;
import br.com.findvet.modelo.Cliente;
import br.com.findvet.modelo.Consulta;
import br.com.findvet.modelo.Parceiro;
import br.com.findvet.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ParceiroService parceiroService;
	@Autowired
	private AnimalService animalService;
	
	public List<ConsultaDto> listaTodasConsultas(){
		List<Consulta> consultas = consultaRepository.findAll();
		return ConsultaDto.converter(consultas);
	}
	
	public List<ConsultaDto> listarConsultaPorCliente(Long id){
		List<Consulta> consultas = consultaRepository.findByCliente(id);
		return ConsultaDto.converter(consultas);
	}
	
	public ResponseEntity<?> cadastrar(ConsultaForm form) {
		Consulta consulta = form.converter();
		Cliente cliente = clienteService.listaClientePorId(form.getId_cliente());
		Animal animal = animalService.listaAnimalPorId(form.getId_animal());
		Parceiro parceiro = parceiroService.listaParceirosPorId(form.getId_parceiro());
		if(cliente!=null && parceiro!=null && animal!=null) {
			if(consulta!=null) {
				consulta.setCliente(cliente);
				consulta.setAnimal(animal);				
				consulta.setParceiro(parceiro);
				consulta.setValor(parceiro.getValor());
				consultaRepository.save(consulta);
				return ResponseEntity.ok().build();
			}
			else {
				 return ResponseEntity.notFound().build();
			}
		}
		 return ResponseEntity.notFound().build();
		
	}
	public ResponseEntity<?> gerarConsulta(Consulta consulta) {
		
		if(consulta!=null) {
				consultaRepository.save(consulta);
				return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<?> remover(Long id){
		if(consultaRepository.findConsultaId(id)!=null) {
			consultaRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
        return ResponseEntity.notFound().build();
	}
	public  ResponseEntity<ConsultaDto> atualizar(Long id, UpdateConsultaForm form) {
		
		ConsultaDto consulta = form.atualizar(id,consultaRepository);
		 if(consulta!=null) {
			 return ResponseEntity.ok(consulta);
		 }
		 return ResponseEntity.notFound().build();
		
	}
	public Consulta buscarConsulta (Long id) {
		Consulta consulta = consultaRepository.findConsultaId(id);
	    if(consulta!=null) {
	    	 return consulta;
	    }
	     return null;
	}

	private void updateStatusConsulta(Consulta consulta) {
		consultaRepository.save(consulta);
	}
	public void aberta(Long id) {
		Consulta consulta = buscarConsulta(id);
		consulta.aberta();
		updateStatusConsulta(consulta);
		
	}
	public void ocorrendo(Long id) {
		Consulta consulta = buscarConsulta(id);
		consulta.ocorrendo();
		updateStatusConsulta(consulta);
	}
	public void finalizada(Long id) {
		Consulta consulta = buscarConsulta(id);
		consulta.finalizada();
		updateStatusConsulta(consulta);
	}
	public void cancelada(Long id) {
		Consulta consulta = buscarConsulta(id);
		consulta.cancelada();
		updateStatusConsulta(consulta);
	}
	
}
