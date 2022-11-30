package com.example.oracle.service.impl;

import com.example.oracle.Entity.Hotel;
import com.example.oracle.repository.RepositoryHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelServiceImp")
public class ServiceImpHotel {
    @Autowired
    @Qualifier("hotelRepository")
    private RepositoryHotel repositoryHotel;

    public List<Hotel> lisAllHotel(){
        return (List<Hotel>) repositoryHotel.findAll();
    }
}
