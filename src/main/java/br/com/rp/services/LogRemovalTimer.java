package br.com.rp.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Singleton
@Startup
public class LogRemovalTimer {

	private static final SimpleDateFormat SD = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	@Resource
	private TimerService timerService;
	
	@Inject	
	private Event<LogRemovedEvent> notifier;

	@PostConstruct
	public void init() {
		ScheduleExpression se = new ScheduleExpression();
		se.month("*").dayOfMonth("*").hour("*").hour("*").minute("*/10").second("*");
		TimerConfig tc = new TimerConfig("Ola Pos Graduacao", true);
		timerService.createCalendarTimer(se, tc);
	}

	@Timeout
	public void executar(Timer timer) {
		System.out.println(String.format("Executando timer em %s com o valor %s",
				SD.format(Calendar.getInstance().getTime()), timer.getInfo()));
		notifier.fire(new LogRemovedEvent());
	}

}
