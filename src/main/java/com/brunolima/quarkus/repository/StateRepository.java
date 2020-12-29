package com.brunolima.quarkus.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import com.brunolima.quarkus.entity.State;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StateRepository implements PanacheRepository<State> {
	public Optional<State> findByCode(String code) {
		return find("code", code).singleResultOptional();
	}

	public List<State> findByName(String name) {
		return list("name", name);
	}

}
