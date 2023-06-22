package br.com.findvet.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.findvet.modelo.Perfil;
import br.com.findvet.repository.PerfilRepository;

@Service
public class PerfilService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> localizarPerfilPorNome(String nome) {
		return perfilRepository.findByNome(nome);
	}

}
