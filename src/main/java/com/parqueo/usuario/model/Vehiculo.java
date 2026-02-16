package com.parqueo.usuario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.parqueo.usuario.model.Usuario;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int anio;
    
    private String categoria;
    private LocalDateTime fechaIngreso;
    
    //Getters y Setters
    public Long getIdVehiculo() {return idVehiculo;}
    public void setIdVehiculo(Long idVehiculo) {this.idVehiculo = idVehiculo;}
    public String getPlaca() {return placa;}
    public void setPlaca(String placa) {this.placa = placa;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public int getAnio() {return anio;}
    public void setAnio(int anio) {this.anio = anio;}
    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public LocalDateTime getFechaIngreso() {return fechaIngreso;}
    public void setFechaIngreso(LocalDateTime fechaIngreso) {this.fechaIngreso = fechaIngreso;}
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}