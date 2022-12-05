package com.example.oracle.repository;

import com.example.oracle.Entity.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("planRepository")
public interface RepositoryPlan extends CrudRepository<Plan, Long> {
    @Query(value = "SELECT * FROM PLAN ORDER BY PLANCODI", nativeQuery = true)
    List<Plan> getPLanOrden();

    @Query(value = "SELECT MAX(PLANCODI) FROM PLAN", nativeQuery = true)
    Long getUltimateId();

}
