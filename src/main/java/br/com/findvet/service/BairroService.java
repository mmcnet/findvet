package br.com.findvet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.findvet.modelo.Bairro;
import br.com.findvet.repository.BairroRepository;

@Service
public class BairroService {
	@Autowired
	private BairroRepository bairroRepository;
	
	public Bairro listaBairroPorId(Long id){
		Bairro bairro = bairroRepository.findBairroId(id);
		return bairro;
	}

}
