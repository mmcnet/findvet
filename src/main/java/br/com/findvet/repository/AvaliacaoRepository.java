package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Avaliacao;

@Repository
public interface AvaliacaoRepository  extends JpaRepository<Avaliacao,Long>{
	
	@Query("SELECT a FROM Avaliacao a WHERE a.consulta.id = :id")
	Avaliacao findByAvaliacaoPorConsulta(Long id);
	@Query("SELECT a FROM Avaliacao a WHERE a.id = :id")
	Avaliacao findByAvaliacaoPorId(Long id);

}
