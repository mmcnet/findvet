package br.com.findvet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.findvet.modelo.Pessoa;
import br.com.findvet.repository.PessoaRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private PessoaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Pessoa> pessoa = repository.findByEmail(username);
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}