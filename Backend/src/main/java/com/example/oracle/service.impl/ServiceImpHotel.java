package com.example.oracle.service.impl;

import com.example.oracle.Entity.Hotel;
import com.example.oracle.repository.RepositoryHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelServiceImp")
public class ServiceImpHotel {
    @Autowired
    @Qualifier("hotelRepository")
    private RepositoryHotel repositoryHotel;

    public List<Hotel> listAllHotel(){
        return (List<Hotel>) repositoryHotel.findAll();
    }

    public Hotel findById(Long id){
        return repositoryHotel.findById(id).orElse(null);
    }

    public Hotel save(Hotel hotel){
        return repositoryHotel.save(hotel);
    }

    public Hotel update(Hotel hotel){
        return repositoryHotel.save(hotel);
    }

    public void delete(Long id){
        repositoryHotel.deleteById(id);
    }

    public List<Hotel> getOrdenHotel(){
       return repositoryHotel.getOrdenHotel();
    }

    public Long getUltimateId() {
        return repositoryHotel.getUltimateId();
    }


}
