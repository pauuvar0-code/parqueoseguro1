package com.parqueo.usuario.service;

import com.parqueo.usuario.model.Usuario;
import com.parqueo.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repositorio;
    
    public UsuarioService(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    public List<Usuario> listar() {
        return repositorio.findAll();
    }
    
    public Usuario guardar(Usuario usuario) {
        return repositorio.save(usuario);
    }
    
    /***Buscar un usuario por ID.*/
    public Usuario buscarPorId(Long idUsuario) {
        Optional<Usuario> usuario = repositorio.findById(idUsuario);
        return usuario.orElse(null);
    }
    
    /***Eliminar un usuario por id*/
    public void eliminar(Long idUsuario) {
        repositorio.deleteById(idUsuario);
    }
}