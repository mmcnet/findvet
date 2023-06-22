package br.com.findvet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.findvet.controller.form.PessoaTemporariaForm;
import br.com.findvet.modelo.PessoaTemporaria;
import br.com.findvet.repository.PessoaTemporariaRepository;

@Service
public class PessoaTemporariaService {
	
	@Autowired
	private PessoaTemporariaRepository pessoaTempRepository;
	
	public ResponseEntity<?> cadastrar(PessoaTemporariaForm form) {
		PessoaTemporaria pessoa = form.converter();
		if(pessoa!=null) {
			pessoaTempRepository.save(pessoa);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
