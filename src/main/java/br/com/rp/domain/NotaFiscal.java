package br.com.rp.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class NotaFiscal implements Serializable {

	private String numero;
	private BigDecimal valor;

	public NotaFiscal(String numero, BigDecimal valor) {
		super();
		this.numero = numero;
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "NotaFiscal [numero=" + numero + ", valor=" + valor + "]";
	}

}
