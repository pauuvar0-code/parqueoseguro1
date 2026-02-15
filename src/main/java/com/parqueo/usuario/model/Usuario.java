package com.parqueo.usuario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nombre;
    private String correo;
    private String telefono;
    private String documento;
    private LocalDateTime fechaRegistro;
    
    @PrePersist
    public void asignarFechaRegistro() {
        this.fechaRegistro = LocalDateTime.now();
    }
    //Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getDocumento() {return documento;}
    public void setDocumento(String documento) {this.documento = documento;}
    public LocalDateTime getFechaRegistro() {return fechaRegistro;}
}