package com.brunolima.quarkus.repository;

import javax.enterprise.context.ApplicationScoped;

import com.brunolima.quarkus.entity.State;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StateRepository implements PanacheRepository<State> {

}
