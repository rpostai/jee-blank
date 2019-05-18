package br.com.rp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class GerenciadorImpressora {
	
	private List<String> impressoes;
	
	public GerenciadorImpressora() {
		impressoes = new ArrayList<>();
	}
	
	@PostConstruct
	public void estabelecerConexaoImpressora() {
		// codigo de conexao com a impressora
	}
	
	@Lock(LockType.WRITE)
	public void adicionaImpressao(String impressao) {
		impressoes.add(impressao);
	}
	
	@Lock(LockType.READ)
	public List<String> getImpressoes() {
		return Collections.unmodifiableList(impressoes);
	}

}
