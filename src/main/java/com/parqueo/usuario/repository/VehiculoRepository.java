package com.parqueo.usuario.repository;

import com.parqueo.usuario.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    
}