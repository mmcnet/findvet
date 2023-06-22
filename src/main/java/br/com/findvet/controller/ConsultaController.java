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

import br.com.findvet.controller.dto.ConsultaDto;
import br.com.findvet.controller.form.ConsultaForm;
import br.com.findvet.controller.form.UpdateConsultaForm;
import br.com.findvet.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping(path = "all")
	@Transactional
	public List<ConsultaDto> getTodasConsultas(){
		return consultaService.listaTodasConsultas();
	}

	@GetMapping(path = "/{id}")
	@Transactional
	public List<ConsultaDto> getConsultaPorCliente(@PathVariable Long id){
		return consultaService.listarConsultaPorCliente(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid ConsultaForm form) {
		consultaService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return consultaService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ConsultaDto> atualizar(@PathVariable Long id, @RequestBody @Valid  UpdateConsultaForm form) {
	   return consultaService.atualizar(id, form);
	}

}
