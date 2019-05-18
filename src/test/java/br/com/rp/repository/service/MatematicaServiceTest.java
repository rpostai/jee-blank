package br.com.rp.repository.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import br.com.rp.AbstractTest;
import br.com.rp.services.MatematicaService;
import br.com.rp.services.MatematicaServiceMulti;

public class MatematicaServiceTest extends AbstractTest {

	@Inject
	private MatematicaService service;

	@Inject
	private MatematicaServiceMulti multi;

	@Test
	public void deveSomarListaInteiros() throws Throwable {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(2);
		list.add(2);
		Integer resultadoSoma = service.soma(list).get();
		assertEquals(Integer.valueOf(6), resultadoSoma);
		Double resultadoMedia = service.media(list).get();
		assertEquals(Double.valueOf(2), resultadoMedia);
	}

	@Test
	public void deveSomarListaInteiros2() throws Throwable {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10000000; i++) {
			list.add(1);
		}
		long inicio = Calendar.getInstance().getTimeInMillis();
		service.soma(list).get();
		long fim = Calendar.getInstance().getTimeInMillis();
		System.out.println("Soma executada em " + (fim - inicio) + " milisegundos ");
		
		inicio = Calendar.getInstance().getTimeInMillis();
		multi.soma(list);
		fim = Calendar.getInstance().getTimeInMillis();
		System.out.println("Soma multi executada em " + (fim - inicio) + " milisegundos ");
		
		
	}
}
