package com.example.oracle.security.service;

import com.example.oracle.security.entity.Usuarios;
import com.example.oracle.security.entity.UsuarioRol;
import com.example.oracle.security.repository.RolRepository;
import com.example.oracle.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
/*
@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    @Qualifier("UserRepository")
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email "+email+" no existe."));

        return new UserDetailsImpl(user);
    }

}
*/
/*
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuarios saveUser(Usuarios user, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuarios userLocal = userRepository.findByUsername(user.getUsername());
        if(userLocal != null){
            System.out.println("El usuario ya Existe");
            throw new Exception("El usuario ya esta presente");
        }else{
            for (UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            user.getUsuarioRoles().addAll(usuarioRoles);
            userLocal = userRepository.save(user);
        }
        return userLocal;

    }

    @Override
    public Usuarios getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void detele(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Long getUltimateId() {
        return userRepository.getUltimateId();
    }
}*/