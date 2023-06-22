package br.com.findvet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Animal;
import br.com.findvet.modelo.Cliente;

@Repository
public interface AnimalRepository  extends JpaRepository<Animal,Long>{
	List<Animal> findByCliente(Cliente cliente);
	Animal findByNome(String nome);
	@Query("SELECT c FROM Animal c WHERE c.id = ?1")
	Animal findAnimalId(Long id);
}
