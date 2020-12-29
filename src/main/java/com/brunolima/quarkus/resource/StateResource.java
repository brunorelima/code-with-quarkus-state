package com.brunolima.quarkus.resource;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brunolima.quarkus.entity.State;

@Path("/states")
public class StateResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<State> list() {
		return Arrays.asList(new State("MG", "Minas Gerais"), new State("SP", "São Paulo"));
	}
}
