package com.brunolima.quarkus.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brunolima.quarkus.entity.City;

public interface CityRepository extends CrudRepository<City, Long> {

	List<City> findByStateCodeIgnoreCase(String stateCode);

}
