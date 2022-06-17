package br.com.stoc.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.FuncionarioModel;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long>{

}
