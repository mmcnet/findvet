package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta,Long>{
	@Query("SELECT p FROM Resposta p WHERE p.pergunta.id = :id")
	Resposta findByRespostaPorPergunta(Long id);
	@Query("SELECT p FROM Resposta p WHERE p.id = :id")
	Resposta findByRespostaPorId(Long id);
}
