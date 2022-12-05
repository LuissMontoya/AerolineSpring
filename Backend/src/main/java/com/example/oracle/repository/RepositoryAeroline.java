package com.example.oracle.repository;

import com.example.oracle.Entity.Aeroline;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("aerolineRepository")
public interface RepositoryAeroline extends CrudRepository<Aeroline, Long> {
    @Query(value = "SELECT * FROM AEROLINE ORDER BY AEROCODI", nativeQuery = true)
    List<Aeroline> getOrdenAeroline();

    @Query(value = "SELECT MAX(AEROCODI) FROM AEROLINE", nativeQuery = true)
    Long getUltimateId();
}
