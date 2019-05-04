package br.com.rp.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Pessoa;

public class PessoalRepositoryImplTest extends AbstractTest {

	@Inject
	private PessoaRepository repository;

	@Test
	public void deveSalvarPessoaComSucesso() throws Throwable {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Rodrigo");
		pessoa.setIdade(22);
		Pessoa pessoaSalva = repository.save(pessoa);
		assertNotNull(pessoaSalva.getId());
	}

	@Test
	public void deveNaoSalvarPessoaPoisFaltamCamposObrigatorios() throws Throwable {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdade(22);
		try {
			repository.save(pessoa);
		} catch (Throwable e) {
			assertTrue(true);
			return;
		}
		assertTrue("Pessoa nao deveria ser salva pois nao tem nome", false);
	}

	@Test
	@UsingDataSet("db/pessoa.xml")
	public void deveRecuperarRegistrosDePessoasComSucesso() throws Throwable {
		List<Pessoa> pessoas = repository.getAll();
		assertEquals(1, pessoas.size());
		assertEquals("Fernanda", pessoas.get(0).getNome());
	}
	
	@Test
	@UsingDataSet("db/pessoa.xml")
	public void deveRecuperarPessoaPorNome() throws Throwable {
		List<Pessoa> pessoas = repository.findPessoaPorNome("Fer");
		assertEquals(1, pessoas.size());
		assertEquals("Fernanda", pessoas.get(0).getNome());
	}
}
