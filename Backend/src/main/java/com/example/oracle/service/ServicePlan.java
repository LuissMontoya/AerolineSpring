package com.example.oracle.service;

import com.example.oracle.Entity.Plan;
import org.springframework.data.domain.Sort;

import java.util.List;


public interface ServicePlan {

    public abstract List<Plan>listAllPlan();

    public abstract Plan findById(Long id);

    public abstract Plan save(Plan plan);

    public abstract Plan update(Plan plan);

    public abstract void delete(Long id);

    public abstract List<Plan> getOrdenPlan();

    public abstract Long getUltimateId();

}
