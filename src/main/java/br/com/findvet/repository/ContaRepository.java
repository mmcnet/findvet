package br.com.findvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long>{
	@Query("SELECT c FROM Conta c WHERE c.id = :id")
	Conta findContaPorId(Long id);
	@Query("SELECT c FROM Conta c LEFT JOIN FETCH c.parceiro WHERE c.parceiro.id = :id" )
	List<Conta> findByContaPorParceiro(Long id);
	@Query("SELECT c FROM Conta c LEFT JOIN FETCH c.banco WHERE c.banco.id = :id" )
	List<Conta> findByContaPorBanco(Long id);
}
