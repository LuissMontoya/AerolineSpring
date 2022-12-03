package com.example.oracle.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AEROLINE")
public class Aeroline {
    @Id
    @Column(name = "AEROCODI")
    private Long codigo;

    @Column(name = "AERONOMB")
    private String nombre;

    @Column(name = "AEROESTA")
    private String estado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
