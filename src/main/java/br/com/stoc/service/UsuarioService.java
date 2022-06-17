package br.com.stoc.service;

import br.com.stoc.model.UsuarioModel;

public interface UsuarioService {
	
	String CadastrarUsuario(UsuarioModel usuario,String confirmarEmail,Long idUsuario);

}
