package br.com.stoc.model;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




	@Entity
	@Table(name = "movimentacao",schema = "stoc")
	public class MovimentacaoModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@Column(name = "id_movimentacao")
		private Long idMovimentacao;
		@Column(name = "id_pedido")
		private Long idPedido;
		@Column(name = "cod_item")
		private Integer codItem;
		@Column(name = "data_cadastro")
		private Date dataCadastro;
		@Column(name = "quantidade_saida")
		private Integer quantidadeSaida;
		@Column(name = "quantidade_entrada")
		private Integer quantidadeEntrada;
		
			
		public Long getIdMovimentacao() {
			return idMovimentacao;
		}
		public void setIdMovimentacao(Long idMovimentacao) {
			this.idMovimentacao = idMovimentacao;
		}
		public Long getIdPedido() {
			return idPedido;
		}
		public void setIdPedido(Long idPedido) {
			this.idPedido = idPedido;
		}
		public Integer getCodItem() {
			return codItem;
		}
		public void setCodItem(Integer codItem) {
			this.codItem = codItem;
		}
		public Date getDataCadastro() {
			return dataCadastro;
		}
		public void setDataCadastro(Date dataCadastro) {
			this.dataCadastro = dataCadastro;
		}
		public Integer getQuantidadeSaida() {
			return quantidadeSaida;
		}
		public void setQuantidadeSaida(Integer quantidadeSaida) {
			this.quantidadeSaida = quantidadeSaida;
		}
		public Integer getQuantidadeEntrada() {
			return quantidadeEntrada;
		}
		public void setQuantidadeEntrada(Integer quantidadeEntrada) {
			this.quantidadeEntrada = quantidadeEntrada;
		}
		
		
		
	}