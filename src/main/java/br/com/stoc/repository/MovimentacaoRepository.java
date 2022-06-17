package br.com.stoc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.MovimentacaoModel;






@Repository
public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, Long>{

}