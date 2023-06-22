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

import br.com.findvet.controller.dto.CartaoDto;
import br.com.findvet.controller.form.CartaoForm;
import br.com.findvet.controller.form.UpdateCartaoForm;
import br.com.findvet.service.CartaoService;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
	
	@Autowired
	private CartaoService cartaoService;

	@GetMapping(path = "/{id}")
	@Transactional
	public List<CartaoDto> getConsultaPorCliente(@PathVariable Long id){
		return cartaoService.listarCartaoPorCliente(id);
	}
	
	@PostMapping(path = "/cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid CartaoForm form) {
		cartaoService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return cartaoService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CartaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateCartaoForm form) {
	   return cartaoService.atualizar(id, form);
	}

}
