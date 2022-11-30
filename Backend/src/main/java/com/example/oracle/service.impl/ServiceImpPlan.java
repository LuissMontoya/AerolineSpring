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
        return (List<Plan>) repositoryPlan.findAll();
    }

}
