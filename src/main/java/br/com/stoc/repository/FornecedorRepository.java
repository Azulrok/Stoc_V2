package br.com.stoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.FornecedorModel;




@Repository
public interface FornecedorRepository extends JpaRepository< FornecedorModel, Long>{

}