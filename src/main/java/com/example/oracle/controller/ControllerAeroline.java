package com.example.oracle.controller;

import com.example.oracle.Entity.Aeroline;
import com.example.oracle.service.impl.ServiceImpAeroline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aeroline/")
@CrossOrigin(origins = "*")
public class ControllerAeroline {

    @Autowired
    @Qualifier("aerolineServiceImp")
    private ServiceImpAeroline serviceImpAeroline;

    @GetMapping(path = "/list/", produces = {"application/json"})
    public List<Aeroline> listAeroline(){
        return serviceImpAeroline.listAllAeroline();
    };
}
