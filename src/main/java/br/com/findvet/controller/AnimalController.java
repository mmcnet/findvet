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

import br.com.findvet.controller.dto.AnimalDto;
import br.com.findvet.controller.form.AnimalForm;
import br.com.findvet.controller.form.UpdateAnimalForm;
import br.com.findvet.modelo.ClientePessoaFisica;
import br.com.findvet.service.AnimalService;
import br.com.findvet.service.ClienteService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalService animalService;
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping(path = "animalCliente")
	public List<AnimalDto> getTodosAnimais(@RequestBody AnimalForm form){
		return animalService.listaAnimalCliente(localizarCliente(form.getCpf()));
	}
	
	@PostMapping(path = "cadastro")
	public void cadastrar(@RequestBody @Valid AnimalForm form) {
		animalService.cadastrar(form,localizarCliente(form.getCpf()));
	}
	private ClientePessoaFisica localizarCliente(String cpf) {
		return clienteService.listaClientesPorCpf(cpf);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return animalService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AnimalDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateAnimalForm form) {
	   return animalService.atualizar(id, form);
	}
}
