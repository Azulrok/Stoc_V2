package br.com.stoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.PedidoModel;
@Repository
public interface PermissaoRepository extends JpaRepository<PedidoModel, Long>{

	@Query(value = "select p.id_permissao "
			+"from Stoc.permissoes p "
			+"where p.nome = ?1"
			+"limit 1", nativeQuery = true)
	Long retornaIdPermissao(String nome_permissao);
}
