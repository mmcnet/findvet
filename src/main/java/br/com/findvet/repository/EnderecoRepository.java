package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{
	Endereco findByNomePrincipal(String nome);
	
}
