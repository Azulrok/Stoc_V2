package br.com.stoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



	
	@Entity
	@Table(name = "pedido",schema = "stoc")
	public class PedidoModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@Column(name = "id_pedido")
		private Long IdPedido;
		@Column(name = "cod_funcionario")
		private Integer CodFuncionario;
		@Column(name = "cod_clienteo")
		private Integer CodCliente;
		@Column(name = "cod_categoria")
		private Integer CodCategoria;
		@Column(name = "cod_item")
		private Integer CodItem;
		@Column(name = "cod_subcategoria")
		private Integer CodSubcategoria;
		public Long getIdPedido() {
			return IdPedido;
		}
		public void setIdPedido(Long idPedido) {
			IdPedido = idPedido;
		}
		public Integer getCodFuncionario() {
			return CodFuncionario;
		}
		public void setCodFuncionario(Integer codFuncionario) {
			CodFuncionario = codFuncionario;
		}
		public Integer getCodCliente() {
			return CodCliente;
		}
		public void setCodCliente(Integer codCliente) {
			CodCliente = codCliente;
		}
		public Integer getCodCategoria() {
			return CodCategoria;
		}
		public void setCodCategoria(Integer codCategoria) {
			CodCategoria = codCategoria;
		}
		public Integer getCodItem() {
			return CodItem;
		}
		public void setCodItem(Integer codItem) {
			CodItem = codItem;
		}
		public Integer getCodSubcategoria() {
			return CodSubcategoria;
		}
		public void setCodSubcategoria(Integer codSubcategoria) {
			CodSubcategoria = codSubcategoria;
		}
	
		
		
		
		
		
		
		
		
}
