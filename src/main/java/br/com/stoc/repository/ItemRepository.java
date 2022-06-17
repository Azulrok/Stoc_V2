package br.com.stoc.repository;

 


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.stoc.model.ItemModel;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long>{

}
