package com.example.oracle.controller;

import com.example.oracle.Entity.Aeroline;
import com.example.oracle.service.impl.ServiceImpAeroline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ControllerAeroline {

    @Autowired
    @Qualifier("aerolineServiceImp")
    private ServiceImpAeroline serviceImpAeroline;

    @GetMapping(path = "/aeroline", produces = {"application/json"})
    public List<Aeroline> listAeroline(){
        return serviceImpAeroline.getOrdenAeroline();
    };

    @GetMapping(path = "/aeroline/{id}")
    public Aeroline findById(@PathVariable Long id){
        Aeroline aeroline = serviceImpAeroline.findById(id);
        if(aeroline == null) {
            throw new RuntimeException("Aeroline id not found -"+id);
        }
        return aeroline;
    }

    @PostMapping(path = "/aeroline")
    public Aeroline save(@RequestBody Aeroline aeroline){
        Long id = serviceImpAeroline.getUltimateId();
        Aeroline aerolineI = new Aeroline();
        aerolineI.setCodigo(id+1);
        aerolineI.setNombre(aeroline.getNombre());
        aerolineI.setEstado(aeroline.getEstado());
        return serviceImpAeroline.save(aerolineI);
    }

    @PutMapping(path = "/aeroline")
    public Aeroline update(@RequestBody Aeroline aeroline){
        Aeroline aeroline2 = serviceImpAeroline.findById(aeroline.getCodigo());
        if( aeroline2 == null) {
            throw new RuntimeException("Aeroline id not found -"+aeroline.getCodigo());
        }
        serviceImpAeroline.update(aeroline);
        return aeroline2;
    }

    @DeleteMapping(path = "/aeroline/{id}")
    public boolean delete(@PathVariable Long id){
        Aeroline aeroline3 = serviceImpAeroline.findById(id);
        if( aeroline3 == null) {
            return false;
        }else{
            serviceImpAeroline.delete(id);
            return true;
        }

    }

}
