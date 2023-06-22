package br.com.findvet.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.FichaDto;
import br.com.findvet.controller.form.FichaForm;
import br.com.findvet.controller.form.UpdateFichaForm;
import br.com.findvet.modelo.Consulta;
import br.com.findvet.modelo.Ficha;
import br.com.findvet.repository.ConsultaRepository;
import br.com.findvet.repository.FichaRepository;

@Service
public class FichaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FichaRepository fichaRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public ResponseEntity<FichaDto> listaFichaPorId(Long id){
		Ficha ficha = fichaRepository.findByFichaPorId(id);
		FichaDto fichaDto = FichaDto.converter(ficha);
		if(fichaDto!=null) {
			return ResponseEntity.ok(fichaDto);
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<FichaDto> listaFichaPorConsulta(Long id){
		Ficha ficha = fichaRepository.findByFichaPorConsulta(id);
		FichaDto fichaDto = FichaDto.converter(ficha);
		if(fichaDto!=null) {
			return ResponseEntity.ok(fichaDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	public void cadastrar(FichaForm form) {
		Consulta consulta = consultaRepository.findConsultaId(form.getConsulta_id());
		if(fichaRepository.findByFichaPorConsulta(form.getConsulta_id())==null) {
			if(consulta!=null) {
				Ficha ficha = form.converter();
				ficha.setConsulta(consulta);
				fichaRepository.save(ficha);
			}
		}
	}
	
	public ResponseEntity<?> remover(Long id){
		if(fichaRepository.findByFichaPorId(id)!=null) {
			fichaRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<FichaDto> atualizar(Long id, UpdateFichaForm form) {
		FichaDto ficha = form.atualizar(id,fichaRepository);
		if(ficha!=null) {
			return ResponseEntity.ok(ficha);
		}
		return ResponseEntity.notFound().build();
	}

}
