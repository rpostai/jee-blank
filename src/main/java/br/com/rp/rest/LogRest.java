package br.com.rp.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.rp.domain.Log;
import br.com.rp.repository.LogRepository;

@Path("/log")
@Consumes("application/json")
@Produces("application/json")
public class LogRest {

	@EJB
	private LogRepository repository;

	@GET
	public List<Log> consultarLogs() {
		return repository.getAll();
	}

	@POST
	public Response salvar(Log log) {
		repository.save(log);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response remove(@PathParam("id") Long id) {
		repository.remove(id);
		return Response.ok().build();
	}
}
