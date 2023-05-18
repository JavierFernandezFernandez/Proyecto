package com.proyecto.TFG.security;

import com.proyecto.TFG.modelos.Usuario;
import com.proyecto.TFG.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario =  usuarioRepositorio.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario con el email "+email+" no exoste"));

        return new UserDetailsImpl(usuario);

    }
}
