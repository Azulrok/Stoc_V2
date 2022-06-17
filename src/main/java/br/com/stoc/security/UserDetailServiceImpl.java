package br.com.stoc.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


import br.com.stoc.model.UsuarioModel;
import br.com.stoc.repository.UsuarioRepository;


@Repository
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

		@Autowired
		private UsuarioRepository usuarioRepository;

		@Override
		public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
			// TODO Auto-generated method stub
			
			UsuarioModel usuario = this.usuarioRepository.getOneByCpf(cpf);
			
			if (usuario == null) {
				throw new UsernameNotFoundException(" Usuário não encontrado.");
		
			}
			
			return new User(usuario.getCpf(),usuario.getPassword(),true,true,true,true,usuario.getAuthorities());
		}
		
	}
