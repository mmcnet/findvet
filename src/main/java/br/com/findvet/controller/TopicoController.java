package br.com.findvet.controller;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.findvet.controller.dto.TopicoDto;
import br.com.findvet.controller.form.TopicoForm;
import br.com.findvet.controller.form.UpdateTopicoForm;
import br.com.findvet.service.TopicoService;


@RestController
@RequestMapping("/topicos")
public class TopicoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TopicoService topicoService;
	
	@GetMapping(path = "all")
	@Transactional
	public List<TopicoDto> listarTodosTopicos(){
		return topicoService.listaTodosTopicos();
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid TopicoForm form) {
		topicoService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return topicoService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateTopicoForm form) {
	   return topicoService.atualizar(id, form);
	}

}
