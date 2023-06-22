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

import br.com.findvet.controller.dto.ContaDto;
import br.com.findvet.controller.form.ContaForm;
import br.com.findvet.controller.form.UpdateContaForm;
import br.com.findvet.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaControlle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping(path = "/{id}")
	@Transactional
	public List<ContaDto> getContaPorCliente(@PathVariable Long id){
		return contaService.getContaPorParceiro(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid ContaForm form) {
		contaService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return contaService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContaDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateContaForm form) {
	   return contaService.atualizar(id, form);
	}

}
