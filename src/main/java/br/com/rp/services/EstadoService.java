package br.com.rp.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.rp.domain.Estado;
import br.com.rp.repository.EstadoRepository;

@Singleton
@Startup
public class EstadoService {

	@Inject
	private EstadoRepository repository;

	private List<Estado> estados;
	
	@PostConstruct
	public void carregarEstados() {
		this.estados = repository.getEstados();
	}

	@Lock(LockType.READ)
	public Optional<Estado> getEstadoPorSigla(String sigla) {
		return estados.stream()
				.filter(e -> e.getSigla().equals(sigla))
				.findFirst();
	}

	@Lock(LockType.READ)
	public List<Estado> getEstados() {
		return Collections.unmodifiableList(estados);
	}

}
