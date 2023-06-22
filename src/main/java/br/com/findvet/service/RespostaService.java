package br.com.findvet.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.RespostaDto;
import br.com.findvet.controller.form.RespostaForm;
import br.com.findvet.controller.form.UpdateRespostaForm;
import br.com.findvet.modelo.Pergunta;
import br.com.findvet.modelo.Resposta;
import br.com.findvet.repository.PerguntaRepository;
import br.com.findvet.repository.RespostaRepository;

@Service
public class RespostaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RespostaRepository respostaRepository;
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	public RespostaDto listarRespostasPorPerguntas(Long id){
		Resposta resposta =  respostaRepository.findByRespostaPorPergunta(id);
		return RespostaDto.converter(resposta);
	}
	
	public void cadastrar(RespostaForm form) {
		Resposta resposta = form.converter();
		Resposta ListarResposta = respostaRepository.findByRespostaPorPergunta(form.getPergunta_id());
		if(ListarResposta==null) {
			Pergunta pergunta = perguntaRepository.findByPerguntaPorId(form.getPergunta_id());
			resposta.setPergunta(pergunta);
			respostaRepository.save(resposta);
		}
	}
	
	public ResponseEntity<?> remover(Long id){
		if(respostaRepository.findByRespostaPorId(id)!=null) {
			respostaRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<RespostaDto> atualizar(Long id, UpdateRespostaForm form) {
		RespostaDto resposta = form.atualizar(id,respostaRepository);
		if(resposta!=null) {
			 return ResponseEntity.ok(resposta);
		}
		 return ResponseEntity.notFound().build();
	}

}
