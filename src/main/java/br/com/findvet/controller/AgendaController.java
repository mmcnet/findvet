package br.com.findvet.controller;


import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/agenda")
public class AgendaController  {

	

	@GetMapping(path = "/{id}")
	@Transactional
	public Long qtdConsultasDoParceiro(@PathVariable Long id) {
		//teste
		return null;
	}

}

