package br.com.findvet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.form.FaleConoscoForm;
import br.com.findvet.modelo.FaleConosco;
import br.com.findvet.repository.FaleConoscoRepository;
@Service
public class FaleConoscoService {
	@Autowired
	private FaleConoscoRepository conoscoRepository;
	
	public void cadastrar(FaleConoscoForm form) {
		FaleConosco fale = form.converter();
		if(fale!=null) {
			conoscoRepository.save(fale);
		}
	}

}
