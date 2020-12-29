package com.brunolima.quarkus.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.brunolima.quarkus.entity.State;
import com.brunolima.quarkus.repository.StateRepository;

@Path("/states")
public class StateResource {
	@Inject
	private StateRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<State> list() {
		return repository.findAll();
	}

	@Path("search/code/{code}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public State findByCode(@PathParam String code) {
		return repository.findByCodeIgnoreCase(code).orElseThrow();
	}

	@Path("search/name/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<State> listByName(@PathParam String name) {
		return repository.findByNameContainsIgnoreCase(name);
	}

	@Path("search/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<State> search(@QueryParam String code, @QueryParam String name) {
		return repository.findByCodeContainsIgnoreCaseAndNameContainsIgnoreCase(code, name);
	}

}
