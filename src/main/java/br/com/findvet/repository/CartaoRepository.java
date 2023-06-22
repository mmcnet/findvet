package br.com.findvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Cartao;

@Repository
public interface CartaoRepository  extends JpaRepository<Cartao,Long>{
	
	@Query("SELECT c FROM Cartao c WHERE c.id = :id")
	Cartao findByCartaoPorId(Long id);
	@Query("SELECT c FROM Cartao c WHERE c.cliente.id = :id")
	List<Cartao> findByCartaoPorCliente(Long id);

}
