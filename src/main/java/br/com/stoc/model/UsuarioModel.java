package br.com.stoc.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;




@Entity
@Table(name = "usuario",schema = "stoc")
public class UsuarioModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;
	
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sexo")
	private String sexo;
	
	
	
	@ManyToMany
	@JoinTable(name="usuarios_permissoes",
	joinColumns={@JoinColumn(name="usuarios_id_usuario", referencedColumnName = "id_usuario")},
	inverseJoinColumns= {@JoinColumn(name="permissoes_id_permissao", referencedColumnName = "id_permissao")})
	private List<PermissaoModel> permissoes;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public List<PermissaoModel> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoModel> permissoes) {
		this.permissoes = permissoes;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.permissoes;
	}
	
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.cpf;
	}

	
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
	
	
	
}