package br.com.rp.repository.service;

import javax.inject.Inject;

import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.services.HelloTimer;

public class HelloTimerTest extends AbstractTest {

	@Inject
	HelloTimer hello;

	@Test
	public void deveExibirHelloWorld() throws Throwable {
		Thread.sleep(20000);
	}
}
