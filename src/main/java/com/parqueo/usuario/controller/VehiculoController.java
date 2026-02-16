package com.parqueo.usuario.controller;

import com.parqueo.usuario.model.Vehiculo;
import com.parqueo.usuario.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    @GetMapping("/usuario/{idUsuario}")
    public List<Vehiculo> listarPorUsuario(@PathVariable Long idUsuario) {
        return vehiculoService.listarPorUsuario(idUsuario);
    }
    
    @GetMapping
    public List<Vehiculo> listarVehiculos() {
        return vehiculoService.listar();
    }
    
    @PostMapping
    public Vehiculo crearVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }
    
    @PutMapping("/{idVehiculo}")
    public Vehiculo actualizarVehiculo(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculoActualizado) {
        return vehiculoService.actualizar(idVehiculo, vehiculoActualizado);
    }
    
    @DeleteMapping("/{idVehiculo}")
    public void eliminarVehiculo(@PathVariable Long idVehiculo) {
        vehiculoService.eliminar(idVehiculo);
    }
}
