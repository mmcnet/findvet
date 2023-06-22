package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Telefone;

@Repository
public interface TelefoneRepository  extends JpaRepository<Telefone,Long>{
	Telefone findByNumeroDotelefone(String numeroCompleto);
}
