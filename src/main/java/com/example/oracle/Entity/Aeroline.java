package com.example.oracle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AEROLINE")
public class Aeroline {
    @Id
    private String aerocodi;

    private String aeronomb;

    private String aeroesta;

    public String getAerocodi() {
        return aerocodi;
    }

    public void setAerocodi(String aerocodi) {
        this.aerocodi = aerocodi;
    }

    public String getAeronomb() {
        return aeronomb;
    }

    public void setAeronomb(String aeronomb) {
        this.aeronomb = aeronomb;
    }

    public String getAeroesta() {
        return aeroesta;
    }

    public void setAeroesta(String aeroesta) {
        this.aeroesta = aeroesta;
    }
}
