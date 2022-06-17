package br.com.stoc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "documento",schema = "stoc")
	public class DocumentoModel implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id
		@Column(name = "id_documento")
		private Long IdDocumento;
		@Column(name = "descricao")
		private String descricao;
		
		
		public Long getIdDocumento() {
			return IdDocumento;
		}
		public void setIdDocumento(Long idDocumento) {
			IdDocumento = idDocumento;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}