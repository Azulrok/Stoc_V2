package br.com.stoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.SetorModel;

@Repository
public interface SetorRepository extends JpaRepository<SetorModel, Long>{

	
}
