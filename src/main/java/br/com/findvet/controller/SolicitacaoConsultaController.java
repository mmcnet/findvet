package br.com.findvet.controller;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.findvet.controller.dto.SolicitacaoConsultaDto;
import br.com.findvet.controller.form.SolicitacaoConsultaForm;
import br.com.findvet.service.SolicitacaoConsultaService;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoConsultaController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SolicitacaoConsultaService solicitacaoConsultaService;
	
	
	@GetMapping(path = "/{id}")
	@Transactional
	public List<SolicitacaoConsultaDto> getSolicitacaoPorCliente(@PathVariable Long id){
		return solicitacaoConsultaService.listarSolicitacaoPorCliente(id);
	}
	
	@PostMapping(path = "cadastro")
	@Transactional
	public void cadastrar(@RequestBody @Valid SolicitacaoConsultaForm form) {
		solicitacaoConsultaService.cadastrar(form);
	}
	
}
