package br.com.stoc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.stoc.model.PermissaoModel;
import br.com.stoc.model.UsuarioModel;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	boolean existsByEmail(String email);
	boolean existsByCpf(String cpf);
	UsuarioModel getOneByCpf(String cpf);
	List<UsuarioModel> findAllByPermissoesIn(List<PermissaoModel > permissoes, Sort nome);
			
	@Modifying
	@Query(value ="update stoc.usuario"
	       +" set senha = ?1"
		   +" where cpf=?2 ", nativeQuery = true )
	@Transactional
	void alterarSenha(String novaSenha, String cpf);

}