package com.example.oracle.controller;

import com.example.oracle.Entity.Plan;
import com.example.oracle.service.impl.ServiceImpPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ControllerPlan {
    @Autowired
    @Qualifier("planServiceImp")
    private ServiceImpPlan serviceImpPlan;

    @GetMapping(path = "/plan", produces = {"application/json"})
    public List<Plan> listPlan(){
    return serviceImpPlan.listAllPlan();
    }

    @GetMapping(path = "/plan/{id}")
    public Plan finById(@PathVariable Long id){
        Plan planA = serviceImpPlan.findById(id);
        if(planA == null) {
            throw new RuntimeException("Plan id not found -"+id);
        }
        return planA;
    }
    @PostMapping(path = "/plan")
    public Plan save(@RequestBody Plan plan){
        Plan planS = serviceImpPlan.save(plan);
        return planS;
    }

    @PutMapping(path = "/plan")
    public Plan update(@RequestBody Plan plan){
        Plan planS = serviceImpPlan.findById(plan.getCodigo());
        if( planS == null) {
            throw new RuntimeException("Plan id not found -"+planS.getCodigo());
        }
        serviceImpPlan.update(plan);
        return planS;
    }

    @DeleteMapping(path = "/plan/{id}")
    public boolean delete(@PathVariable long id){
        Plan planD = serviceImpPlan.findById(id);

        if(planD == null ){
            return false;
        }else{
            serviceImpPlan.delete(id);
            return true;
        }
    }

}
