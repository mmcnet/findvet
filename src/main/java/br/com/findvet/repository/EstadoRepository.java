package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.findvet.modelo.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado,Long>{

}
