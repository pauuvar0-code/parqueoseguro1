package com.parqueo.usuario.repository;

import com.parqueo.usuario.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByUsuarioIdUsuario(Long idUsuario);
}