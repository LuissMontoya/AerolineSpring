package com.example.oracle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PLAN")
public class Plan {
    @Id
    private String plancodi;

    private String plannomb;

    public String getPlancodi() {
        return plancodi;
    }

    public void setPlancodi(String plancodi) {
        this.plancodi = plancodi;
    }

    public String getPlannomb() {
        return plannomb;
    }

    public void setPlannomb(String plannomb) {
        this.plannomb = plannomb;
    }
}
