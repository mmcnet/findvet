package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long>{
	@Query("SELECT t FROM Topico t WHERE t.nome LIKE %:nome%")
	Topico findByTopicoPorNome(@Param("nome") String nome);
	@Query("SELECT t FROM Topico t WHERE t.id = :id")
	Topico findByTopicoPorId(Long id);
}
