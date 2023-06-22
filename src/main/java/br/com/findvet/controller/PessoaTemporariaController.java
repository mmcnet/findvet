package br.com.findvet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.findvet.controller.form.PessoaTemporariaForm;
import br.com.findvet.service.PessoaTemporariaService;

@Controller
public class PessoaTemporariaController {
	
	@Autowired
	private PessoaTemporariaService pessoaService;
	
	@RequestMapping(value="/pessoa/cadastro" , method=RequestMethod.POST)
	public String cadastrar(PessoaTemporariaForm form) {
		pessoaService.cadastrar(form);
		return "redirect:/";
	}

}
