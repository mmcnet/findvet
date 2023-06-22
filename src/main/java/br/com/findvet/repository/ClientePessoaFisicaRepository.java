package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.ClientePessoaFisica;

@Repository
public interface ClientePessoaFisicaRepository extends JpaRepository<ClientePessoaFisica,Long>{
	ClientePessoaFisica findByNome(String nome);
	
	@Query("SELECT c FROM ClientePessoaFisica c WHERE c.cpf LIKE %:cpf%")
	ClientePessoaFisica findByCpf(@Param("cpf") String cpf);
	
	@Query("SELECT c FROM ClientePessoaFisica c WHERE c.id = :id")
	ClientePessoaFisica findClienteId(Long id);
	
	ClientePessoaFisica findByEmail(String email);
}
