package com.example.oracle.security.controller;

import com.example.oracle.security.entity.Rol;
import com.example.oracle.security.entity.UsuarioRol;
import com.example.oracle.security.entity.Usuarios;
import com.example.oracle.security.repository.UserRepository;
import com.example.oracle.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Qualifier("UserRepository")
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public List<Usuarios> listUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/")
    public Usuarios saveUser(@RequestBody Usuarios user) throws Exception{
        Set<UsuarioRol> roles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolName("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUser(user);
        usuarioRol.setRol(rol);

        return userService.saveUser(user, roles);
    }

    @GetMapping("/{username}")
    public Usuarios getUser(@PathVariable("username") String username){
    return  userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId ){
        userService.detele(userId);
    }

}
