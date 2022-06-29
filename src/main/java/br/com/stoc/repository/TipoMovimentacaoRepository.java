package br.com.stoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.stoc.model.TipoMovimentacaoModel;

 @Repository
 public interface TipoMovimentacaoRepository extends JpaRepository<TipoMovimentacaoModel, Long>{

}
