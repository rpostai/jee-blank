package br.com.rp.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/teste")
@Consumes("application/json")
@Produces("application/json")
public class TestRest {

	@GET
	public String test() {
		return "teste";
	}

}
