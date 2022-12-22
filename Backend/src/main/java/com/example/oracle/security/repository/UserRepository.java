package com.example.oracle.security.repository;

import com.example.oracle.security.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByUsername(String username);

    @Query(value = "SELECT MAX(USUACODI) FROM USUARIOS", nativeQuery = true)
    Long getUltimateId();

    Optional<Usuarios> findOneByEmail(String email);
}
