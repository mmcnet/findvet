package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Banco;
@Repository
public interface BancoRepository extends JpaRepository<Banco,Long>{
	
	Banco findByNome(String nome);
	@Query("SELECT b FROM Banco b WHERE b.codigo = :codigo")
	Banco findByCodigo(String codigo);
	@Query("SELECT b FROM Banco b WHERE b.id = :id")
	Banco findBancoById(Long id);
}
