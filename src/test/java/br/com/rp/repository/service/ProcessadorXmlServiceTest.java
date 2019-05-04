package br.com.rp.repository.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.inject.Inject;

import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.services.ProcessadorXmlService;

public class ProcessadorXmlServiceTest extends AbstractTest {
	
	@Inject
	ProcessadorXmlService service;

	@Test
	public void deveSalvarXml() throws Throwable {
		Files.deleteIfExists(Paths.get("d:\\teste.txt"));
		service.salvar("<xml>");
		assertTrue(new File("d:\\teste.txt").exists());
		String arquivoLido = new String(Files.readAllBytes(Paths.get("d:\\teste.txt")));
		assertEquals("<xml>", arquivoLido);
	}

}
