package com.example.oracle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name="PLAN")
public class Plan {
    @Id
    private Long plancodi;

    private String plannomb;

    public Long getPlancodi() {
        return plancodi;
    }

    public void setPlancodi(Long plancodi) {
        this.plancodi = plancodi;
    }

    public String getPlannomb() {
        return plannomb;
    }

    public void setPlannomb(String plannomb) {
        this.plannomb = plannomb;
    }
}
