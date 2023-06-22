package br.com.findvet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.findvet.modelo.FaleConosco;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco,Long>{

}
