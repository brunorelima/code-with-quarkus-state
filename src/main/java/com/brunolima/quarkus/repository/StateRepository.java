package com.brunolima.quarkus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.brunolima.quarkus.entity.State;

public interface StateRepository extends CrudRepository<State, Long> {

	public Optional<State> findByCode(String code);

	public List<State> findByNameContainsIgnoreCase(String name);

	public List<State> findByCodeContainsIgnoreCaseAndNameContainsIgnoreCase(String code, String name);

}
