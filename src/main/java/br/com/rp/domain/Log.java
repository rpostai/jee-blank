package br.com.rp.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vbn_log")
public class Log extends BaseEntity {

	@Column(name = "tipo_operacao")
	@Enumerated(EnumType.STRING)
	private TipoOperacao tipoOperacao;

	@Column(name = "data_operacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(name = "usuario", length = 100, nullable = false)
	@Size(min=3, max=100)
	private String usuario;

	@Lob
	@Column(name = "detalhes")
	@Basic(fetch = FetchType.LAZY)
	private String detalhes;

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	@PrePersist
	public void atualizaData() {
		data = Calendar.getInstance().getTime();
	}

}
