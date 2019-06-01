package br.com.rp.services;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.com.rp.domain.NotaFiscal;

@MessageDriven(activationConfig = { 
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/notafiscal"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class ImpressaoNotaFiscalConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		ObjectMessage om = (ObjectMessage) message;
		try {
			NotaFiscal nota = (NotaFiscal) om.getObject();
			System.out.println(nota);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
