package com.example.oracle.service;

import com.example.oracle.Entity.Hotel;
import com.example.oracle.Entity.Plan;

import java.util.List;

public interface ServiceHotel {
    public abstract List<Hotel> listAllHotel();

    public abstract Hotel findById(Long id);

    public abstract Hotel save(Hotel hotel);

    public abstract Hotel update(Hotel hotel);

    public void delete(Long id);

    public abstract List<Hotel> getOrdenHotel();

    public abstract Long getUltimateId();
}
