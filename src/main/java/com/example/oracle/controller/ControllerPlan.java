package com.example.oracle.controller;

import com.example.oracle.Entity.Plan;
import com.example.oracle.service.impl.ServiceImpPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plan")
@CrossOrigin(origins = "*")
public class ControllerPlan {
    @Autowired
    @Qualifier("planServiceImp")
    private ServiceImpPlan planService;

    @GetMapping(path = "/list/", produces = {"application/json"})
    public List<Plan> listPlan(){
    return planService.listAllPlan();
    }

}
