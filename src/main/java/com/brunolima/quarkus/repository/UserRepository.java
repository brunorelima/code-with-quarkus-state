package com.brunolima.quarkus.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.brunolima.quarkus.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByUserName(String username);

}
