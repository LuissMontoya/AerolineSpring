package com.example.oracle.security.entity;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.Name;

@Entity
@Table(name = "USUARIOROL")
public class UsuarioRol {
    @Id
    @SequenceGenerator(name = "SEC_USER_ROL", sequenceName = "SEC_USER_ROL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_USER_ROL" )
    //@Column(name = "USUARIOROLID")
    //Enumerated(EnumType.STRING)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    //@Column(name="USUARIO")
    private Usuarios user;

    @ManyToOne
    //@Column(name="ROL")
    private Rol rol;

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
