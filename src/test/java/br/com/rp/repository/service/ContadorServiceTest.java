package br.com.rp.repository.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.services.ContadorService;

public class ContadorServiceTest extends AbstractTest {

	@Inject
	private ContadorService contador;

	@Test
	public void deveIncrementar() {
		contador.add();
		contador.add();
		contador.add();
		assertEquals(3, contador.get());
	}

	@Test
	public void deveIncrementarConcorrente() throws Throwable {
		List<CompletableFuture<Void>> list = new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			Runnable r = () -> contador.add();
			list.add(CompletableFuture.runAsync(r));
		}
		CompletableFuture[] arr = new CompletableFuture[list.size()];
		list.toArray(arr);
		CompletableFuture<Void> allOf = CompletableFuture.allOf(arr);
		allOf.get();
		assertEquals(5000,contador.get());
	}

}
