package com.brunolima.quarkus.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brunolima.quarkus.entity.State;
import com.brunolima.quarkus.repository.StateRepository;

@Path("/states")
public class StateResource {
	@Inject
	private StateRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<State> list() {
		return repository.listAll();
	}
}
