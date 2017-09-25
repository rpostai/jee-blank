package br.com.rp.repository;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Log;
import br.com.rp.domain.TipoOperacao;
import br.com.rp.repository.LogRepository;

public class LogRepositoryTest extends AbstractTest {

	@EJB
	private LogRepository repository;

	@Before
	public void setup() {

	}

	@Test
	public void deveInserirLogComSucesso() {
		Log log = new Log();
		log.setTipoOperacao(TipoOperacao.EXTRATO);
		log.setData(Calendar.getInstance().getTime());
		log.setUsuario("rodrigo");
		log.setDetalhes("Consulta Extrato Mes 6");
		log = repository.save(log);
		Assert.assertNotNull(log.getId());

	}

	@Test(expected = EJBTransactionRolledbackException.class)
	public void deveNaoInserirLogPorFaltaDeUsuario() {
		Log log = new Log();
		log.setTipoOperacao(TipoOperacao.EXTRATO);
		log.setData(Calendar.getInstance().getTime());
		log.setDetalhes("Consulta Extrato Mes 6");
		log = repository.save(log);
	}

	@Test
	@UsingDataSet("db/log.xml")
	public void deveRecuperar2LogsExistentes() {
		List<Log> logs = repository.getAll();
		Assert.assertEquals(2, logs.size());
	}

	@Test
	@UsingDataSet("db/log.xml")
	public void deveRemoverLogComSucesso() {
		repository.remove(100001l);
		Assert.assertEquals(1, repository.getAll().size());
	}
	
	@Test
	public void deveExistirDataAlteracao() {
		Log log = new Log();
		log.setTipoOperacao(TipoOperacao.EXTRATO);
		log.setDetalhes("Consulta Extrato Mes 6");
		log.setUsuario("rodrigo");
		log = repository.save(log);
		
		Assert.assertNotNull(log.getData());
	}
	
	@Test(expected=Exception.class)
	public void deveFalharPoisNaoUsuarioNaoTem3Digitos() {
		Log log = new Log();
		log.setTipoOperacao(TipoOperacao.EXTRATO);
		log.setDetalhes("Consulta Extrato Mes 6");
		log.setUsuario("pr");
		log = repository.save(log);
	}

}
