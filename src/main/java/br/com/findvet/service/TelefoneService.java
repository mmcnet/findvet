package br.com.findvet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.findvet.modelo.Pessoa;
import br.com.findvet.modelo.Telefone;
import br.com.findvet.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public void setTelefone(List<Telefone> telefones,Pessoa pessoa) {
		for (Telefone telefone : telefones) {
			telefone.setPessoa(pessoa);
			telefoneRepository.save(telefone);
		}
	}

}
