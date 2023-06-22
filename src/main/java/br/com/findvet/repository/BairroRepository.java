package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Bairro;

@Repository
public interface BairroRepository  extends JpaRepository<Bairro,Long>{
	
	@Query("SELECT b FROM Bairro b WHERE b.id = ?1")
	Bairro findBairroId(Long id);

}
