package br.com.findvet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{
	
	Optional<Pessoa>findByEmail(String email);

}
