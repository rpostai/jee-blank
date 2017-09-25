package br.com.rp.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.rp.domain.Log;
import br.com.rp.repository.LogRepository;

@Stateless
public class LogService {

	@EJB
	private LogRepository repository;

	public List<Log> getAllLogs() {
		return repository.getAll();
	}
}
