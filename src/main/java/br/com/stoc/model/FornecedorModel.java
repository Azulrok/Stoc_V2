package br.com.stoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "fornecedor",schema = "stoc")
public class FornecedorModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fornecedor")
	private Long IdFornecedor;
	@Column(name = "numero")
	private Integer Numero;
	@Column(name = "nome")
	private String Nome;
	@Column(name = "empresa")
	private String Empresa;
	@Column(name = "email")
	private String Email;
	public Long getIdFornecedor() {
		return IdFornecedor;
	}
	public void setIdFornecedor(Long idFornecedor) {
		IdFornecedor = idFornecedor;
	}
	public Integer getNumero() {
		return Numero;
	}
	public void setNumero(Integer numero) {
		Numero = numero;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmpresa() {
		return Empresa;
	}
	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
	
	
	
	
	
	