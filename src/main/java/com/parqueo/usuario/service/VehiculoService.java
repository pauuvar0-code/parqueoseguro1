package com.parqueo.usuario.service;

import com.parqueo.usuario.model.Vehiculo;
import com.parqueo.usuario.model.Usuario;
import com.parqueo.usuario.repository.UsuarioRepository;
import com.parqueo.usuario.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.time.LocalDateTime;

@Service
public class VehiculoService {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    //Listar todos
    public List<Vehiculo> listar() {
        return vehiculoRepository.findAll();
    }
    
    //Crear
    public Vehiculo guardar(Vehiculo vehiculo) {
        vehiculo.setFechaIngreso(LocalDateTime.now());
        if(vehiculo.getUsuario() != null) {
            Long IdUsuario = vehiculo.getUsuario().getIdUsuario();
            Usuario usuario = usuarioRepository.findById(IdUsuario)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            
            vehiculo.setUsuario(usuario);
        }
        return vehiculoRepository.save(vehiculo);
    }
    
    //Actualizar
    public Vehiculo actualizar(Long idVehiculo, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));
        
        vehiculo.setPlaca(vehiculoActualizado.getPlaca());
        vehiculo.setMarca(vehiculoActualizado.getMarca());
        vehiculo.setModelo(vehiculoActualizado.getModelo());
        vehiculo.setColor(vehiculoActualizado.getColor());
        vehiculo.setAnio(vehiculoActualizado.getAnio());
        vehiculo.setCategoria(vehiculoActualizado.getCategoria());
        
        return vehiculoRepository.save(vehiculo);
    }
    
    //Eliminar
    public void eliminar(Long idVehiculo) {
        vehiculoRepository.deleteById(idVehiculo);
    }
    
    //Listar por usuario
    public List<Vehiculo> listarPorUsuario(Long idUsuario) {
        return vehiculoRepository.findByUsuarioIdUsuario(idUsuario);
    }
}