package br.com.findvet.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.AvaliacaoDto;
import br.com.findvet.controller.form.AvaliacaoForm;
import br.com.findvet.controller.form.UpdateAvaliacaoForm;
import br.com.findvet.modelo.Avaliacao;
import br.com.findvet.modelo.Consulta;
import br.com.findvet.repository.AvaliacaoRepository;
import br.com.findvet.repository.ConsultaRepository;

@Service
public class AvaliacaoService implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public ResponseEntity<AvaliacaoDto> listaAvaliacaoPorConsulta(Long id){
		Avaliacao avaliacao =  avaliacaoRepository.findByAvaliacaoPorConsulta(id);
		AvaliacaoDto avaliacaoDto = AvaliacaoDto.converter(avaliacao);
		if(avaliacaoDto!=null) {
			return ResponseEntity.ok(avaliacaoDto);
		}
		 return ResponseEntity.notFound().build();
	}
	
	public void cadastrar(AvaliacaoForm form) {
		Avaliacao avaliacao = form.converter();
		if(avaliacaoRepository.findByAvaliacaoPorConsulta(form.getConsulta_id())==null) {
			Consulta consulta = consultaRepository.findConsultaId(form.getConsulta_id());
			avaliacao.setConsulta(consulta);
			avaliacaoRepository.save(avaliacao);
		}
	}
	
	public ResponseEntity<?> remover(Long id){
		if(avaliacaoRepository.findByAvaliacaoPorId(id)!=null) {
			avaliacaoRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<AvaliacaoDto> atualizar(Long id, UpdateAvaliacaoForm form) {
		AvaliacaoDto avaliacao = form.atualizar(id,avaliacaoRepository);
		if(avaliacao!=null) {
			 return ResponseEntity.ok(avaliacao);
		}
		return ResponseEntity.notFound().build();
	}


}
