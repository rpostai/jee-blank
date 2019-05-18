package br.com.rp.services;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class HelloTimer {

	@Schedule(second="*/1", minute="*", hour="*", dayOfMonth="*")
	public void hello() {
		System.out.println("Hello World");
	}
}
