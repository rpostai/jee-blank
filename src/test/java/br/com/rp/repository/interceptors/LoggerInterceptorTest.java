package br.com.rp.repository.interceptors;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.NotaFiscal;
import br.com.rp.interceptors.ServicoTeste;

public class LoggerInterceptorTest extends AbstractTest {

	@Inject
	private ServicoTeste servico;

	@Test
	public void deveExecutarLog() {
		servico.executar(new NotaFiscal("100", BigDecimal.ZERO));
	}

}
