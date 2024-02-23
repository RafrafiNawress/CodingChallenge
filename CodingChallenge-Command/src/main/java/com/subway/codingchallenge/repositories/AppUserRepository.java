package com.subway.codingchallenge.repositories;

import com.subway.codingchallenge.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

	public AppUser findByUsername(String username);


}
