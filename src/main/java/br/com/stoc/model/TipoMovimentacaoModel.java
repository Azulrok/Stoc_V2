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
	@Table(name = "Tipo_Movimentacao",schema = "stoc")
	public class TipoMovimentacaoModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_tipo_movimentacao")
		private Long idTipoMovimentacao;
		@Column(name = "nome")
		private String nome;
		@OneToMany(mappedBy="tipoMovimentacao")
		private List<MovimentacaoModel> movimentacao;
				
		public List<MovimentacaoModel> getMovimentacao() {
			return movimentacao;
		}
		public void setMovimentacao(List<MovimentacaoModel> movimentacao) {
			this.movimentacao = movimentacao;
		}
		public Long getIdTipoMovimentacao() {
			return idTipoMovimentacao;
		}
		public void setIdTipoMovimentacao(Long idTipoMovimentacao) {
			this.idTipoMovimentacao = idTipoMovimentacao;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
		
	
	
	
	
}
