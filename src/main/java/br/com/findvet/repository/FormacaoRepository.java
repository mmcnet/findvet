package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.findvet.modelo.Formacao;

public interface FormacaoRepository extends JpaRepository<Formacao,Long>{
	@Query("SELECT f FROM Formacao f WHERE f.id = :id")
	Formacao findByFormacaoPorId(Long id);
	@Query("SELECT f FROM Formacao f WHERE f.parceiro.id = :id")
	Formacao findByFormacaoPorParceiro(Long id);

}
