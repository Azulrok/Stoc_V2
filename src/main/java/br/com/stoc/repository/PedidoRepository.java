package br.com.stoc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.PedidoModel;




@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long>{

}
