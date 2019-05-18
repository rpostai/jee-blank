package br.com.rp.services;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
@Asynchronous
public class MatematicaService {

	public Future<Integer> soma(List<Integer> valores) {
//		Integer total = 0;
//		for (Integer valor: valores) {
//			total += valor;
//		}
		return new AsyncResult<Integer>(valores.stream().reduce((a, b) -> a + b).get());
	}

	public Future<Double> media(List<Integer> valores) {
		try {
			Integer soma = soma(valores).get();
			return new AsyncResult<Double>(Double.valueOf( soma / valores.size()));
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

}
