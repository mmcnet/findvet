package br.com.findvet.controller;

import java.io.Serializable;

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

import br.com.findvet.controller.dto.PerguntaDto;
import br.com.findvet.controller.form.PerguntaForm;
import br.com.findvet.controller.form.UpdatePerguntaForm;
import br.com.findvet.service.PerguntaService;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping(path = "/{id}")
	@Transactional
	public PerguntaDto listarPerguntaPorTopico(@PathVariable Long id){
		return perguntaService.listaTodasPerguntasPorTopicos(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid PerguntaForm form) {
		perguntaService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return perguntaService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PerguntaDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdatePerguntaForm form) {
	   return perguntaService.atualizar(id, form);
	}
}
