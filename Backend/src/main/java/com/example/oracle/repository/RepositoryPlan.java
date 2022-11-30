package com.example.oracle.repository;

import com.example.oracle.Entity.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("planRepository")
public interface RepositoryPlan extends CrudRepository<Plan, Long> {

}
