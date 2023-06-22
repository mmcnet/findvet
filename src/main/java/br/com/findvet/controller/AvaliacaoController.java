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

import br.com.findvet.controller.dto.AvaliacaoDto;
import br.com.findvet.controller.form.AvaliacaoForm;
import br.com.findvet.controller.form.UpdateAvaliacaoForm;
import br.com.findvet.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<AvaliacaoDto> listarPerguntaPorTopico(@PathVariable Long id){
		return avaliacaoService.listaAvaliacaoPorConsulta(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid AvaliacaoForm form) {
		avaliacaoService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return avaliacaoService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	
	public ResponseEntity<AvaliacaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateAvaliacaoForm form) {
	   return avaliacaoService.atualizar(id, form);
	}
	
	

}
