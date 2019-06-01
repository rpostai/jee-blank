package br.com.rp.services;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.rp.domain.NotaFiscal;

@Stateless
public class NotaFiscalService {
	
	private static final Logger logger = LoggerFactory.getLogger(NotaFiscalService.class);

	@Inject
	private JMSContext context;

	@Resource(lookup = "java:/jms/queue/notafiscal")
	Destination fila;

	public void imprimirNotaFiscal(NotaFiscal nota) {
		logger.info("Iniciando envio de impressao de nota fiscal");
		ObjectMessage om = context.createObjectMessage(nota);
		context.createProducer().send(fila, om);
		logger.info("Finalizando envio impressao de nota fiscal");
	}
	
	public void reimprimirNotaFiscal(NotaFiscal nota) {
		logger.info("Iniciando reimpressao de nota fiscal");
		// faz alguma coisa
		logger.info("Finalizand; reimpressao de nota fiscal");
	}
	
	public void cancelarNotaFiscal(NotaFiscal nota) {
		logger.info("Cancelando nota Fiscal");
	}

}
