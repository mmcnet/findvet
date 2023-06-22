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

import br.com.findvet.controller.dto.FormacaoDto;
import br.com.findvet.controller.form.FormacaoForm;
import br.com.findvet.controller.form.UpdateFormacaoForm;
import br.com.findvet.service.FormacaoService;

@RestController
@RequestMapping("/formacao")
public class FormacaoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FormacaoService formacaoService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<FormacaoDto> listarFormacaoPorParceiro(@PathVariable Long id){
		return formacaoService.listarFormacaoPorParceiro(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid FormacaoForm form) {
		formacaoService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return formacaoService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FormacaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateFormacaoForm form) {
	   return formacaoService.atualizar(id, form);
	}

}
