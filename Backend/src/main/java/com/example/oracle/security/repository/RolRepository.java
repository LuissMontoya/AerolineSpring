package com.example.oracle.security.repository;

import com.example.oracle.Entity.Aeroline;
import com.example.oracle.security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByRolName(String rolName);

    public abstract Rol save(Rol rol);
}
