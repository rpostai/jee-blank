package br.com.rp.interceptors;

import java.util.Calendar;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggerInterceptor {

	@AroundInvoke
	public Object log(InvocationContext ic) throws Exception {
		Calendar dataInicio = Calendar.getInstance();
		Object obj = ic.proceed();
		Calendar dataFim = Calendar.getInstance();
		
		Object[] parameters = ic.getParameters();
		for (Object param: parameters) {
			System.out.println(param);
		}
		
		System.out.println(String.format("Servico %s executou em %d milisegundos", ic.getMethod().getName(),
				dataFim.getTimeInMillis() - dataInicio.getTimeInMillis()));
		return obj;
	}
}
