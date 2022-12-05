package com.example.oracle.service.impl;

import com.example.oracle.Entity.Aeroline;
import com.example.oracle.repository.RepositoryAeroline;
import com.example.oracle.service.ServiceAeroline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("aerolineServiceImp")
@Transactional
public class ServiceImpAeroline implements ServiceAeroline {
    @Autowired
    @Qualifier("aerolineRepository")
    private RepositoryAeroline repositoryAeroline;

    @Override
    public List<Aeroline> listAllAeroline() {
        return (List<Aeroline>) repositoryAeroline.findAll();
    }

    @Override
    public Aeroline findById(Long id) {
        return repositoryAeroline.findById(id).orElse(null);
    }

    @Override
    public Aeroline save(Aeroline aeroline) {
        return repositoryAeroline.save(aeroline);
    }

    @Override
    public Aeroline update(Aeroline aeroline) {
        return repositoryAeroline.save(aeroline);
    }

    @Override
    public void delete(Long id) {
        repositoryAeroline.deleteById(id);
    }

    @Override
    public List<Aeroline> getOrdenAeroline() {
        return repositoryAeroline.getOrdenAeroline();
    }

    @Override
    public Long getUltimateId() {
        return repositoryAeroline.getUltimateId();
    }
}
