package br.com.rp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeuLogger {
	
	private static final Logger logger = LoggerFactory.getLogger(NotaFiscalService.class);
	
	public void log() {
		logger.info("Executando logger");
	}

}
