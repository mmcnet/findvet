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

import br.com.findvet.controller.dto.BancoDto;
import br.com.findvet.controller.form.BancoForm;
import br.com.findvet.controller.form.UpdateBancoForm;
import br.com.findvet.service.BancoService;

@RestController
@RequestMapping("/bancos")
public class BancoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private BancoService bancoService;

	@GetMapping(path = "/all")
	@Transactional
	public List<BancoDto> getBancos(){
		return bancoService.listarBancos();
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid BancoForm form) {
		bancoService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return bancoService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BancoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateBancoForm form) {
	   return bancoService.atualizar(id, form);
	}

	
	
}
