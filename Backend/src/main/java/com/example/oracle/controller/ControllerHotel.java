package com.example.oracle.controller;

import com.example.oracle.Entity.Hotel;
import com.example.oracle.service.impl.ServiceImpHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControllerHotel {
    @Autowired
    @Qualifier("hotelServiceImp")
    private ServiceImpHotel serviceImpHotel;

    @GetMapping(path = "/hotel", produces = {"application/json"})
    public List<Hotel> listHotel(){
        return serviceImpHotel.lisAllHotel();
    }

    @GetMapping(path = "/hotel/{id}")
    public Hotel findById(@PathVariable Long id){
        Hotel hotel = serviceImpHotel.findById(id);
        if(hotel == null) {
            throw new RuntimeException("Hotel id not found -"+id);
        }
        return hotel;
    }

    @PostMapping(path = "/hotel")
    public Hotel save(@RequestBody Hotel hotel){
        Hotel hotelS = serviceImpHotel.save(hotel);
        return hotelS;
    }

    @PutMapping(path = "/hotel")
    public Hotel update(@RequestBody Hotel hotel){
        Hotel hotelU = serviceImpHotel.findById(hotel.getCodigo());
        if( hotelU == null) {
            throw new RuntimeException("Hotel id not found -"+hotel.getCodigo());
        }
        serviceImpHotel.update(hotel);
        return hotelU;
    }

    @DeleteMapping(path = "/hotel/{id}")
    public String delete(@PathVariable Long id){
        Hotel hotelD = serviceImpHotel.findById(id);
        if( hotelD == null) {
            throw new RuntimeException("User id not found -"+id);
        }
        serviceImpHotel.delete(id);
        return "Deleted Hotel id - "+id;
    }

}
