package com.example.oracle.repository;

import com.example.oracle.Entity.Aeroline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("aerolineRepository")
public interface RepositoryAeroline extends CrudRepository<Aeroline, String> {

}
