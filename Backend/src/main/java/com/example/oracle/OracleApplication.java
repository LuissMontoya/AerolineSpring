package com.example.oracle;

import com.example.oracle.security.entity.Rol;
import com.example.oracle.security.entity.Usuarios;
import com.example.oracle.security.entity.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OracleApplication implements CommandLineRunner{

	//@Autowired
	//private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OracleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Usuarios usuario = new Usuarios();
		//usuario.setId(1L);
		usuario.setUsername("Alex3");
		usuario.setEmail("alex3@gmail.com");
		usuario.setPassword("12345");

		Rol rol = new Rol();
		//rol.setId(1L);
		rol.setRolName("ADMIN");
		System.out.println("ROL -> " + rol.getRolName() +  ' '+ rol.getId());

		Set<UsuarioRol> usuariosRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		//usuarioRol.setUsuarioRolId(1L);
		usuarioRol.setRol(rol);
		usuarioRol.setUser(usuario);
		System.out.println("el usuario es -> "+usuario.getId() + ' '+  usuario.getUsername());
		usuariosRoles.add(usuarioRol);
		//System.out.println("el usuario rol es -> "+ usuarioRol.getUsuarioRolId().toString() + ' '+  usuarioRol.getUser().toString() + ' '+ usuarioRol.getRol().toString());
		Usuarios usuarioGuardado = userService.saveUser(usuario,usuariosRoles);
		System.out.println(usuarioGuardado.getUsername());

		 */

	}
}
