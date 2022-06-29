package br.com.stoc.model;



import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;




	@Entity
	@Table(name = "movimentacao",schema = "stoc")
	public class MovimentacaoModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_movimentacao")
		private Long idMovimentacao;
		@Column(name = "id_setor")
		private Long idSetor;
		@Column(name = "id_item")
		private Integer idItem;
		@Column(name = "data_cadastro")
		private Date dataCadastro;
		@Column(name = "quantidade")
		private Integer quantidade;
		@Column(name = "id_tipo_movimentacao")
		private Long idTipoMovimentacao;
		
		@ManyToOne
		@JoinColumn(name="id_setor", insertable = false,updatable = false)
		private SetorModel setor;
		
		@ManyToOne
		@JoinColumn(name="id_item", insertable = false,updatable = false)
		private ItemModel item;
		
		@ManyToOne
		@JoinColumn(name="id_tipo_movimentacao", insertable = false,updatable = false)
		private TipoMovimentacaoModel tipoMovimentacao;		
	
		
		public TipoMovimentacaoModel getTipoMovimentacao() {
			return tipoMovimentacao;
		}
		public void setTipoMovimentacao(TipoMovimentacaoModel tipoMovimentacao) {
			this.tipoMovimentacao = tipoMovimentacao;
		}
		public ItemModel getItem() {
			return item;
		}
		public void setItem(ItemModel item) {
			this.item = item;
		}
		public SetorModel getSetor() {
			return setor;
		}
		public void setSetor(SetorModel setor) {
			this.setor = setor;
		}
		public Long getIdMovimentacao() {
			return idMovimentacao;
		}
		public void setIdMovimentacao(Long idMovimentacao) {
			this.idMovimentacao = idMovimentacao;
		}

		public Long getIdSetor() {
			return idSetor;
		}
		public void setIdSetor(Long idSetor) {
			this.idSetor = idSetor;
		}
		public Integer getIdItem() {
			return idItem;
		}
		public void setIdItem(Integer idItem) {
			this.idItem = idItem;
		}
		public Date getDataCadastro() {
			return dataCadastro;
		}
		public void setDataCadastro(Date dataCadastro) {
			
			this.dataCadastro = dataCadastro;
		}	
		public Long getIdTipoMovimentacao() {
			return idTipoMovimentacao;
		}
		public void setIdTipoMovimentacao(Long idTipoMovimentacao) {
			this.idTipoMovimentacao = idTipoMovimentacao;
		}
		public Integer getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}
	
	}