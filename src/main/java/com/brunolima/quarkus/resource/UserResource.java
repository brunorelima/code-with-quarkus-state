package com.brunolima.quarkus.resource;

import java.util.Optional;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.brunolima.quarkus.entity.User;
import com.brunolima.quarkus.repository.UserRepository;

@Path("/users")
public class UserResource {

	@Inject
	UserRepository repository;

	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<User> listAll() {
		return repository.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(User inputUser) {
		repository.save(inputUser);
	}

	@Path("/{username}")
	@DELETE
	@RolesAllowed("admin")
	@Transactional
	public void delete(@PathParam String username) {
		Optional<User> userSearched = repository.findByUserName(username);
		User user = userSearched.orElseThrow();
		repository.delete(user);
	}

	@Path("/whoami")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String myself(@Context SecurityContext context) {
		return context.getUserPrincipal() != null ? context.getUserPrincipal().getName() : "vazio";
	}

}
