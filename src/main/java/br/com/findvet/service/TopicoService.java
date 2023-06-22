package br.com.findvet.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.dto.TopicoDto;
import br.com.findvet.controller.form.TopicoForm;
import br.com.findvet.controller.form.UpdateTopicoForm;
import br.com.findvet.modelo.Topico;
import br.com.findvet.repository.TopicoRepository;

@Service
public class TopicoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TopicoRepository topicoRepository;
	
	public List<TopicoDto> listaTodosTopicos(){
		List<Topico> topicos = topicoRepository.findAll();
		return TopicoDto.converter(topicos);
	}
	
	public void cadastrar(TopicoForm form) {
		Topico topico = form.converter();
		Topico verificaTopico = topicoRepository.findByTopicoPorNome(form.getNome());
		if(verificaTopico==null) {
			topicoRepository.save(topico);
		}
	}
	
	public ResponseEntity<?> remover(Long id){
		if(topicoRepository.findByTopicoPorId(id)!=null) {
			topicoRepository.deleteById(id);
	        return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	public ResponseEntity<TopicoDto> atualizar(Long id, UpdateTopicoForm form) {
		TopicoDto ficha = form.atualizar(id,topicoRepository);
		if(ficha!=null) {
			return ResponseEntity.ok(ficha);
		}
		return ResponseEntity.notFound().build();
	}
}
