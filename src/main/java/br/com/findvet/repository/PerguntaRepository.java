package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta,Long>{
	@Query("SELECT p FROM Pergunta p WHERE p.topico.id = :id")
	Pergunta findByPerguntaPorTopico(Long id);
	@Query("SELECT p FROM Pergunta p WHERE p.id = :id")
	Pergunta findByPerguntaPorId(Long id);
}
