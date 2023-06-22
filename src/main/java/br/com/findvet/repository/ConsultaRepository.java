package br.com.findvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta,Long>{
	@Query("SELECT c FROM Consulta c WHERE c.id = :id")
	Consulta findConsultaId(Long id);
	@Query("SELECT c FROM Consulta c LEFT JOIN FETCH c.cliente WHERE c.cliente.id = :id" )
	List<Consulta> findByCliente(Long id);
}
