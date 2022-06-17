package br.com.stoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	
	
	
	
	@Entity
	@Table(name = "funcionario",schema = "stoc")
	public class FuncionarioModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@Column(name = "id_funcionario")
		private Long IdFuncionario;
		@Column(name = "cpf_funcionario")
		private Integer CpfFuncionario;
		@Column(name = "nome_funcionario")
		private String NomeFuncionario;
		@Column(name = "tipo_funcionario")
		private String TipoFuncionario;
		@Column(name = "email_funcionario")
		private String EmailFuncionario;
		@Column(name = "senha_funcionario")
		private String SenhaFuncionario;
		
		
		
		public Long getIdFuncionario() 
		
		
		{
			return IdFuncionario;
		}
		public void setIdFuncionario(Long idFuncionario) {
			IdFuncionario = idFuncionario;
		}
		public Integer getCpf_Funcionario() {
			return CpfFuncionario;
		}
		public void setCpf_Funcionario(Integer cpf_Funcionario) {
			CpfFuncionario = cpf_Funcionario;
		}
		public String getNome_Funcionario() {
			return NomeFuncionario;
		}
		public void setNome_Funcionario(String nome_Funcionario) {
			NomeFuncionario = nome_Funcionario;
		}
		public String getTipo_Funcionario() {
			return TipoFuncionario;
		}
		public void setTipo_Funcionario(String tipo_Funcionario) {
			TipoFuncionario = tipo_Funcionario;
		}
		public String getEmail_Funcionario() {
			return EmailFuncionario;
		}
		public void setEmail_Funcionario(String email_Funcionario) {
			EmailFuncionario = email_Funcionario;
		}
		public String getSenhaFuncionario() {
			return SenhaFuncionario;
		}
		public void setSenhaFuncionario(String senhaFuncionario) {
			SenhaFuncionario = senhaFuncionario;
		}

		
		
		
		
}
