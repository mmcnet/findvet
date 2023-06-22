package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Pais;

@Repository
public interface PaisRepository  extends JpaRepository<Pais,Long>{

}
