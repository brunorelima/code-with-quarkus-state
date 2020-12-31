package com.brunolima.quarkus.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.brunolima.quarkus.entity.City;
import com.brunolima.quarkus.repository.CityRepository;

@Path("/cities")
public class CityResource {

	@Inject
	CityRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<City> listAll() {
		return repository.findAll();
	}

	@Path("search/statecode/{statecode}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> listByState(@PathParam String statecode) {
		return repository.findByStateCodeIgnoreCase(statecode);
	}

}
