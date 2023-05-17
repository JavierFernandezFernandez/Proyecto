package com.proyecto.TFG.security;

import com.proyecto.TFG.modelos.Usuario;
import com.proyecto.TFG.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDataServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario =usuarioRepository.findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario con email "+email+" no existe."));

        return new UserDetailsImpl(usuario);
    }
}
