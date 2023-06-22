package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Ficha;

@Repository
public interface FichaRepository extends JpaRepository<Ficha,Long>{
	@Query("SELECT f FROM Ficha f WHERE f.consulta.id = :id")
	Ficha findByFichaPorConsulta(Long id);
	@Query("SELECT f FROM Ficha f WHERE f.id = :id")
	Ficha findByFichaPorId(Long id);
}
