package br.com.rp.services;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class LogRemovedObserver {
	public void handleLogRemoved(@Observes LogRemovedEvent event) {
		System.out.println("Log foi removido com sucesso");
	}
}
