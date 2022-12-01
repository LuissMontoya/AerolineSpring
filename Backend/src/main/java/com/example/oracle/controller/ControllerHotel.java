package com.example.oracle.controller;

import com.example.oracle.Entity.Hotel;
import com.example.oracle.service.impl.ServiceImpHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControllerHotel {
    @Autowired
    @Qualifier("hotelServiceImp")
    private ServiceImpHotel serviceImpHotel;

    @GetMapping(path = "/list/", produces = {"application/json"})
    public List<Hotel> listHotel(){
        return serviceImpHotel.lisAllHotel();
    }
}
