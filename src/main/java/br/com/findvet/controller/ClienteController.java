package br.com.findvet.controller;

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

import br.com.findvet.controller.dto.ClienteDto;
import br.com.findvet.controller.form.ClienteForm;
import br.com.findvet.controller.form.UpdateClienteForm;
import br.com.findvet.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping(path = "/cliente/{cpf}")
	public ClienteDto getCliente(@PathVariable String cpf){
		return clienteService.listaCliente(cpf);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteForm form) {
		return clienteService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return clienteService.remover(id);
	}
	@PutMapping("/{cpf}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable String cpf, @RequestBody @Valid UpdateClienteForm form) {
	   return  clienteService.atualizar(cpf, form);
	}
}
