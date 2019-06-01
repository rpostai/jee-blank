package br.com.rp.interceptors;

import java.util.Calendar;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class HorarioInterceptor {

	@AroundInvoke
	public Object checarHorario(InvocationContext ic) throws Exception {
		Calendar agora = Calendar.getInstance();
		int hora = agora.get(Calendar.HOUR_OF_DAY);
		if (hora >= 8 && hora < 18) {
			return ic.proceed();
		} else
			throw new RuntimeException("Horario para execucao desta tarefa deve ser entre 8 e 18 horas");
	}
}
