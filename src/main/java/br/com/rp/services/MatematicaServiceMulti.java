package br.com.rp.services;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MatematicaServiceMulti {

	@Inject
	private MatematicaService service;

	public Integer soma(List<Integer> valores) throws Exception {
		if (valores.size() > 10) {
			int meio = (int) Math.round(valores.size() / 2);
			Future<Integer> soma = service.soma(valores.subList(0, meio));
			Future<Integer> soma2 = service.soma(valores.subList(meio, valores.size()));
			return soma.get() + soma2.get();
		}
		return service.soma(valores).get();
	}
}
