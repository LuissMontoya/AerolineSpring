package com.example.oracle.Entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name="PLAN")
public class Plan {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLANCODI")
    private Long codigo;

    @Column(name = "PLANNOMB")
    private String nombre;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
