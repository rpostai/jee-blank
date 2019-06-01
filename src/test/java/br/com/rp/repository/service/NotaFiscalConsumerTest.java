package br.com.rp.repository.service;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.NotaFiscal;
import br.com.rp.services.NotaFiscalService;

public class NotaFiscalConsumerTest extends AbstractTest{

	@Inject
	private NotaFiscalService nfs;

	@Test
	public void deveEnviareConsumirNotaFiscal() {
		NotaFiscal n1 = new NotaFiscal("AB", new BigDecimal(100));
		NotaFiscal n2 = new NotaFiscal("AC", new BigDecimal(200));
		NotaFiscal n3 = new NotaFiscal("AD", new BigDecimal(400));
		nfs.imprimirNotaFiscal(n1);
		nfs.imprimirNotaFiscal(n2);
		nfs.imprimirNotaFiscal(n3);
	}
}
