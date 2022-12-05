package com.example.oracle.service;

import com.example.oracle.Entity.Aeroline;
import com.example.oracle.Entity.Hotel;
import com.example.oracle.Entity.Plan;

import java.util.List;

public interface ServiceAeroline {
    public  abstract List<Aeroline> listAllAeroline();

    public abstract Aeroline findById(Long id);

    public abstract Aeroline save(Aeroline aeroline);

    public abstract Aeroline update(Aeroline aeroline);

    public void delete(Long id);

    public abstract List<Aeroline> getOrdenAeroline();

    public abstract Long getUltimateId();
}
