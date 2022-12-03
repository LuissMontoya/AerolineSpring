package com.example.oracle.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HOTEL")
public class Hotel {
    @Id
    @Column(name = "HOTECODI")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "HOTENOMB")
    private String nombre;

    @Column(name = "HOTENIT")
    private String nit;

    @Column(name = "HOTEDIRE")
    private String direccion;

    @Column(name = "HOTETELE")
    private Long telefono;

    @Column(name = "HOTEESTA")
    private String estado;

    @Column(name = "HOTEEMAI")
    private String email;

    @Column(name = "HOTECELU")
    private Long celular;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }
}
