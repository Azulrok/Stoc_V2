package br.com.stoc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "setor",schema = "stoc")
public class SetorModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_setor")
	private Long idSetor;
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy="setor")
	private List<MovimentacaoModel> movimentacao;
	
	
	
	public List<MovimentacaoModel> getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(List<MovimentacaoModel> movimentacao) {
		this.movimentacao = movimentacao;
	}
	public Long getIdSetor() {
		return idSetor;
	}
	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}