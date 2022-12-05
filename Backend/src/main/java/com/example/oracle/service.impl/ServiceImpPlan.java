package com.example.oracle.service.impl;

import com.example.oracle.Entity.Plan;
import com.example.oracle.repository.RepositoryPlan;
import com.example.oracle.service.ServicePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("planServiceImp")
@Transactional
public class ServiceImpPlan implements ServicePlan {
    @Autowired
    @Qualifier("planRepository")
    private RepositoryPlan repositoryPlan;

    @Override
    public List<Plan> listAllPlan() {
        return (List<Plan>) repositoryPlan.getPLanOrden();
    }

    @Override
    public Plan findById(Long id) {
        return repositoryPlan.findById(id).orElse(null);
    }

    @Override
    public Plan save(Plan plan) {
        long id =  repositoryPlan.getUltimateId();
        //System.out.println("el id es-> "+id);
        Plan planI_ = new Plan();
        planI_.setCodigo(id+1);
        planI_.setNombre(plan.getNombre());
        return repositoryPlan.save(planI_);
    }

    @Override
    public Plan update(Plan plan) {
        return repositoryPlan.save(plan);
    }

    @Override
    public void delete(Long id) {
        repositoryPlan.deleteById(id);
    }

    @Override
    public List<Plan> getOrdenPlan() {
        return (List<Plan>) repositoryPlan.getPLanOrden();
    }

    @Override
    public Long getUltimateId() {
        return repositoryPlan.getUltimateId();
    }


}
