package com.example.oracle.repository;

import com.example.oracle.Entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hotelRepository")
public interface RepositoryHotel extends CrudRepository<Hotel, Long> {
    @Query(value = "SELECT * FROM HOTEL WHERE HOTECODI <> -1 ORDER BY HOTECODI ", nativeQuery = true)
    List<Hotel> getOrdenHotel();

    @Query(value = "SELECT MAX(HOTECODI) FROM HOTEL", nativeQuery = true)
    Long getUltimateId();
}
