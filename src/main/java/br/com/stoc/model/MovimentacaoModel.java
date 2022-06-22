package br.com.stoc.model;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
		private Long id_movimentacao;
		@Column(name = "id_pedido")
		private Long id_pedido;
		@Column(name = "cod_item")
		private Integer cod_item;
		@Column(name = "cod_dataentrada")
		private LocalDateTime cod_dataentrada;
		@Column(name = "cod_datasaida")
		private LocalDateTime cod_datasaida;
		@Column(name = "cod_quantentrada")
		private Integer cod_quantentrada;
		@Column(name = "cod_quantsaida")
		private Integer cod_quantsaida;
		public Long getId_movimentacao() {
			return id_movimentacao;
		}
		public void setId_movimentacao(Long id_movimentacao) {
			this.id_movimentacao = id_movimentacao;
		}
		public Long getId_pedido() {
			return id_pedido;
		}
		public void setId_pedido(Long id_pedido) {
			this.id_pedido = id_pedido;
		}
		public Integer getCod_item() {
			return cod_item;
		}
		public void setCod_item(Integer cod_item) {
			this.cod_item = cod_item;
		}
		public LocalDateTime getCod_dataentrada() {
			return cod_dataentrada;
		}
		public void setCod_dataentrada(LocalDateTime cod_dataentrada) {
			this.cod_dataentrada = cod_dataentrada;
		}
		public LocalDateTime getCod_datasaida() {
			return cod_datasaida;
		}
		public void setCod_datasaida(LocalDateTime cod_datasaida) {
			this.cod_datasaida = cod_datasaida;
		}
		public Integer getCod_quantentrada() {
			return cod_quantentrada;
		}
		public void setCod_quantentrada(Integer cod_quantentrada) {
			this.cod_quantentrada = cod_quantentrada;
		}
		public Integer getCod_quantsaida() {
			return cod_quantsaida;
		}
		public void setCod_quantsaida(Integer cod_quantsaida) {
			this.cod_quantsaida = cod_quantsaida;
		}
	
		
		
		
		
	}