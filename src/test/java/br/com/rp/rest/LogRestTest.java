package br.com.rp.rest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.domain.Log;

public class LogRestTest extends AbstractRestTest {

	private static final String URL = "http://localhost:8080/vbank/api/";

	@Test
	public void deveRetornarTeste() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL + "teste");
		String result = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).get(String.class);
		assertNotNull(result);
	}

	@Test
	@UsingDataSet("db/log.xml")
	public void deveRetornar2LogsPeloRest() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL + "log");
		List<Log> logs = target.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Log>>() {
				});
		Assert.assertEquals(2, logs.size());
	}

}
