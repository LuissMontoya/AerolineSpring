package com.example.oracle.repository;

import com.example.oracle.Entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("hotelRepository")
public interface RepositoryHotel extends CrudRepository<Hotel, Long> {

}
