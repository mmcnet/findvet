package br.com.findvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.SolicitacaoConsulta;
@Repository
public interface SolicitacaoConsultaRepository   extends JpaRepository<SolicitacaoConsulta,Long>{
	
	@Query("SELECT c FROM SolicitacaoConsulta c WHERE c.id = :id")
	SolicitacaoConsulta findSolicitacaoById(Long id);
	@Query("SELECT c FROM SolicitacaoConsulta c LEFT JOIN FETCH c.cliente WHERE c.cliente.id = :id" )
	List<SolicitacaoConsulta> findSolicitacaoByCliente(Long id);

}
