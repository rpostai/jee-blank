package br.com.rp.services;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class ContadorService {

	private int contador;
	
	@Lock(LockType.READ)
	public void add() {
//		try {
//			Thread.sleep(1000l);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		contador = contador+1;
		System.out.println("Contador: " + contador  + " - " +Thread.currentThread().getName());
	}

	@Lock(LockType.READ)
	public int get() {
		return contador;
	}
}
