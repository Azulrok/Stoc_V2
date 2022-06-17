package br.com.stoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stoc.model.UsuarioModel;
import br.com.stoc.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private String mensagem;

	@Override
	public String CadastrarUsuario(UsuarioModel usuario, String confirmarEmail,Long idUsuario) {
		mensagem = null;	
		System.out.println("Entrei");
		
		//Verifica se já existe um usuário com o mesmo cpf no banco de dados
		if (this.usuarioRepository.existsByCpf(usuario.getCpf())) {
			this.mensagem = "Já existe um usuário cadastrado com esse cpf.";
			
		}
		//Verifica se já existe um usuário com o mesmo email no banco de dados
		else if (this.usuarioRepository.existsByEmail(usuario.getEmail())) {
			this.mensagem = "Já existe um usuário cadastrado com esse email.";
		}
		//Verifica se os emails estão diferentes
		else if (!usuario.getEmail().equals(confirmarEmail)) {
			this.mensagem = "Os emails enviados estão com valores diferentes.";
		}		
		else
		{
			if (usuario != null) {
				usuario.setId_usuario(idUsuario);			
			}
		
			this.mensagem = "Usuário cadastrado com sucesso.";
			//O método save salva uma informação nova ou atualiza se o ID estiver setado
			this.usuarioRepository.save(usuario);
			
		}
		
		return mensagem;
	}

	
}
