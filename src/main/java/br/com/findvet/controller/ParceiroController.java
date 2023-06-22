package br.com.findvet.controller;

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

import br.com.findvet.controller.dto.ParceiroDto;
import br.com.findvet.controller.form.ParceiroForm;
import br.com.findvet.controller.form.UpdateParceiroForm;
import br.com.findvet.service.ParceiroService;

@RestController
@RequestMapping("/parceiros")
public class ParceiroController {

	@Autowired
	private ParceiroService parceiroService;
	
	@GetMapping(path = "all")
	public List<ParceiroDto> getTodosParceiro(){
		return parceiroService.listaTodosParceiros();
	}
	
	@GetMapping(path = "/parceiro/{cpf}")
	public ParceiroDto listarParceiroPorCpf(@PathVariable String cpf){
		return parceiroService.listaParceirosPorCpf(cpf);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ParceiroForm form) {
		return parceiroService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return parceiroService.remover(id);
	}
	@PutMapping("/{cpf}")
	@Transactional
	public ResponseEntity<ParceiroDto> atualizar(@PathVariable String cpf, @RequestBody @Valid  UpdateParceiroForm form) {
	   return parceiroService.atualizar(cpf, form);
	}
}
