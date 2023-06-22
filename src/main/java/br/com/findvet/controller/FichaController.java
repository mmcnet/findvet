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

import br.com.findvet.controller.dto.FichaDto;
import br.com.findvet.controller.form.FichaForm;
import br.com.findvet.controller.form.UpdateFichaForm;
import br.com.findvet.service.FichaService;

@RestController
@RequestMapping("/fichas")
public class FichaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private FichaService fichaService;
	
	@GetMapping(path = "/{id}")
	@Transactional
	public ResponseEntity<FichaDto>  listaFichaPorId(@PathVariable Long id){
		return fichaService.listaFichaPorId(id);
	}
	
	@GetMapping(path = "/consulta/{id}")
	@Transactional
	public ResponseEntity<FichaDto> listaFichaPorConsulta(@PathVariable  Long id){
		return fichaService.listaFichaPorConsulta(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid FichaForm form) {
		fichaService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return fichaService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FichaDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateFichaForm form) {
	   return fichaService.atualizar(id, form);
	}
}
