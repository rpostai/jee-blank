package br.com.rp.rest;

import java.net.URL;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Assert;
import org.junit.Test;

import br.com.rp.domain.Log;

public class LogRestTest extends AbstractRestTest {

	private static final String URL = "http://localhost:8080/vbank/api/log";

	@Test
	@UsingDataSet("db/log.xml")
	public void deveRetornar2LogsPeloRest() {
	//	System.out.println(baseURI.getPath() + "/api/log");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(URL);
		Response response = target.request().get();
		List<Log> logs = (List<Log>) response.getEntity();
		Assert.assertEquals(2, logs.size());
	}

}
