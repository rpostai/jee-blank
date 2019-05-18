package br.com.rp.repository.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.domain.Estado;
import br.com.rp.services.EstadoService;

public class EstadoServiceTest extends AbstractTest {

	@Inject
	private EstadoService estado;

	@Before
	public void setup() throws Throwable {
		List<Estado> estados = new ArrayList<>();
		estados.add(new Estado("PR", "Parana"));
		estados.add(new Estado("SC", "Santa Catarina"));
		estados.add(new Estado("SP", "Sao Paulo"));
		String conteudoArquivo = estados.stream().map(e -> {
			return e.getSigla() + ";" + e.getNome();
		}).collect(Collectors.joining("\n"));
		Files.write(Paths.get("d:/rpostai/estados.txt"), conteudoArquivo.getBytes());
	}

	@Test
	public void deveCarregarEstadoPR() {
		Optional<Estado> pr = estado.getEstadoPorSigla("PR");
		assertTrue(pr.isPresent());
		assertEquals("Parana", pr.get().getNome());
		Optional<Estado> sc = estado.getEstadoPorSigla("SC");
		assertTrue(sc.isPresent());
	}

	@Test
	public void deveNaoEncontrarEstado() {
		Optional<Estado> resultado = estado.getEstadoPorSigla("MM");
		assertFalse(resultado.isPresent());
	}

	@Test
	public void deveEncontrarTodosEstados() {
		List<Estado> estados = estado.getEstados();
		assertEquals(3, estados.size());
	}
}
