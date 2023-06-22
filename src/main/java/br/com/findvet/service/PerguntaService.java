package br.com.findvet.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.PerguntaDto;
import br.com.findvet.controller.form.PerguntaForm;
import br.com.findvet.controller.form.UpdatePerguntaForm;
import br.com.findvet.modelo.Pergunta;
import br.com.findvet.modelo.Topico;
import br.com.findvet.repository.PerguntaRepository;
import br.com.findvet.repository.TopicoRepository;

@Service
public class PerguntaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PerguntaRepository perguntaRepository;
	@Autowired
	private TopicoRepository topicoRepository;
	
	public PerguntaDto listaTodasPerguntasPorTopicos(Long id){
		Pergunta pergunta =  perguntaRepository.findByPerguntaPorTopico(id);
		return PerguntaDto.converter(pergunta);
	}
	
	public void cadastrar(PerguntaForm form) {
		Pergunta pergunta = form.converter();
		Pergunta EncontraPergunta = perguntaRepository.findByPerguntaPorTopico(form.getTopico_id());
		if(EncontraPergunta==null) {
			Topico topico = topicoRepository.findByTopicoPorId(form.getTopico_id());
			pergunta.setTopico(topico);
			perguntaRepository.save(pergunta);
		}
	}
	
	public ResponseEntity<?> remover(Long id){
		
		if(perguntaRepository.findByPerguntaPorId(id)!=null) {
			perguntaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<PerguntaDto> atualizar(Long id, UpdatePerguntaForm form) {
		PerguntaDto pergunta = form.atualizar(id,perguntaRepository);
		if(pergunta!=null) {
			return ResponseEntity.ok(pergunta);
		}
		return ResponseEntity.notFound().build();
	}

}
