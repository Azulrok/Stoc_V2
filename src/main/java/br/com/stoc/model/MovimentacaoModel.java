package br.com.stoc.model;

import java.io.Serializable;

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
		private Long IdMovimentacao;
		@Column(name = "cod_item")
		private Integer CodItem;
		@Column(name = "cod_data")
		private Integer CodData;
		public Long getIdMovimentacao() {
			return IdMovimentacao;
		}
		public void setIdMovimentacao(Long idMovimentacao) {
			IdMovimentacao = idMovimentacao;
		}
		public Integer getCod_Item() {
			return CodItem;
		}
		public void setCod_Item(Integer cod_Item) {
			CodItem = cod_Item;
		}
		public Integer getCod_Data() {
			return CodData;
		}
		public void setCod_Data(Integer cod_Data) {
			CodData = cod_Data;
		}
	
		
		
		
		
}
