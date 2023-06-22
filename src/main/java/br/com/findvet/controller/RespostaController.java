package br.com.findvet.controller;

import java.io.Serializable;

import javax.transaction.Transactional;

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

import br.com.findvet.controller.dto.RespostaDto;
import br.com.findvet.controller.form.RespostaForm;
import br.com.findvet.controller.form.UpdateRespostaForm;
import br.com.findvet.service.RespostaService;

@RestController
@RequestMapping("/respostas")
public class RespostaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RespostaService respostaService;
	
	@GetMapping(path = "/{id}")
	public RespostaDto listarPerguntaPorTopico(@PathVariable Long id){
		return respostaService.listarRespostasPorPerguntas(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody RespostaForm form) {
		respostaService.cadastrar(form);
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return respostaService.remover(id);
	}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<RespostaDto> atualizar(@PathVariable Long id, @RequestBody  UpdateRespostaForm form) {
	   return respostaService.atualizar(id, form);
	}

}
