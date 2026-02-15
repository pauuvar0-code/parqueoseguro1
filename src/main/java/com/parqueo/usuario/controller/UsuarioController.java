package com.parqueo.usuario.controller;

import com.parqueo.usuario.model.Usuario;
import com.parqueo.usuario.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import com.parqueo.usuario.repository.UsuarioRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
private UsuarioRepository usuarioRepository;
    
    private final UsuarioService servicio;
    
    public UsuarioController(UsuarioService servicio) {
        this.servicio = servicio;
    }
    
    @GetMapping
    public List<Usuario> listar() {
        return servicio.listar();
    }
    
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return servicio.guardar(usuario);
    }
    
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long idUsuario) {
        return servicio.buscarPorId(idUsuario);
    }
    
    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@PathVariable Long idUsuario,@RequestBody Usuario usuarioActualizado) {
        
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + idUsuario));
        
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setCorreo(usuarioActualizado.getCorreo());
        usuario.setTelefono(usuarioActualizado.getTelefono());
        
        return usuarioRepository.save(usuario);
    }
    @DeleteMapping("/{idUsuario}")
    public void eliminar(@PathVariable Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
