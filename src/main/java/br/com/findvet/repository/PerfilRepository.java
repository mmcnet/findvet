package br.com.findvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Long>{
	
	@Query("SELECT p FROM Perfil p WHERE p.nome LIKE %:nome%")
	public List<Perfil> findByNome(@Param("nome") String nome);

}
