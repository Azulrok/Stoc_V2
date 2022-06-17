package br.com.stoc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.DocumentoModel;






@Repository
public interface DocumentoRepository extends JpaRepository<DocumentoModel, Long>{

}