package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.ParceiroPessoaFisica;

@Repository
public interface ParceiroPessoaFisicaRepository extends JpaRepository<ParceiroPessoaFisica,Long>{
	ParceiroPessoaFisica findByNome(String nome);
	
	@Query("SELECT c FROM ParceiroPessoaFisica c WHERE c.cpf = ?1")
	ParceiroPessoaFisica findByCpf(String cpf);
	
	@Query("SELECT c FROM ParceiroPessoaFisica c WHERE c.id = ?1")
	ParceiroPessoaFisica findParceiroId(Long id);
	
	ParceiroPessoaFisica findByEmail(String email);

}
