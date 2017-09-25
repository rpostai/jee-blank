package br.com.rp.repository.impl;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import br.com.rp.domain.Log;
import br.com.rp.domain.TipoOperacao;
import br.com.rp.repository.LogRepository;

public class LogInterceptor {

	@EJB
	private LogRepository repository;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		if (ic.getTarget() instanceof LogRepository) {
			return ic.proceed();
		} else {
			try {
				return ic.proceed();
			} finally {
				saveLog(ic.getTarget().getClass().getSimpleName(), ic.getMethod().getName(), ic.getParameters());
			}
		}
	}

	private void saveLog(String className, String method, Object[] parameters) {
		Log log = new Log();
		log.setTipoOperacao(TipoOperacao.EXTRATO);
		log.setDetalhes(className + method + parameters);
		log.setUsuario("xpto");
		repository.save(log);
	}

}
