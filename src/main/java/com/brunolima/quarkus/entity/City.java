package com.brunolima.quarkus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	private State state;

	@Deprecated
	public City() {
	}

	public City(String name, State state) {
		super();
		this.name = name;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}

}
