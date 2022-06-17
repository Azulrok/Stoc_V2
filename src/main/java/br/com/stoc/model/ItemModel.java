package br.com.stoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	@Entity
	@Table(name = "item",schema = "stoc")
	public class ItemModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_item")
		private Long IdItem;
		@Column(name = "quantidade")
		private Integer Quantidade;
		@Column(name = "descricao")
		private String Descricao;
		@Column(name = "localizar")
		private String Localizar;
		@Column(name = "nome")
		private String Nome;
		public Long getIdItem() {
			return IdItem;
		}
		public void setIdItem(Long idItem) {
			IdItem = idItem;
		}
		public Integer getQuantidade() {
			return Quantidade;
		}
		public void setQuantidade(Integer quantidade) {
			Quantidade = quantidade;
		}
		public String getDescricao() {
			return Descricao;
		}
		public void setDescricao(String descricao) {
			Descricao = descricao;
		}
		public String getLocalizar() {
			return Localizar;
		}
		public void setLocalizar(String localizar) {
			Localizar = localizar;
		}
		public String getNome() {
			return Nome;
		}
		public void setNome(String nome) {
			Nome = nome;
		}
		
		
		
		
		
}
