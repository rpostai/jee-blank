package br.com.rp.repository.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.rp.domain.Log;
import br.com.rp.repository.LogRepository;

@Stateless
public class LogRepositoryImpl extends AbstractRepositoryImpl<Log> implements LogRepository {

	public LogRepositoryImpl() {
		super(Log.class);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Log save(Log object) {
		return super.save(object);
	}
}
