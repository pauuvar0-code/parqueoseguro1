package com.parqueo.usuario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
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
    
    @NotBlank(message = "La placa es obligatoria")
    @Size(min= 6, max= 6, message= "La placa debe tener exactamente 6 caracteres")
    private String placa;
    
    @NotBlank(message= "La marca es obligatoria")
    private String marca;
    
    @NotBlank(message= "El modelo es obligatorio")
    private String modelo;
    
    @NotBlank(message= "El color es obligatorio")
    private String color;
    
    @NotNull(message= "El año es obligatorio")
    @Min(value= 1900, message="El año no puede ser menor a 1900")
    @Max(value= 2100, message="El año no puede ser mayor a 2100")
    private Integer anio;
    
    @NotBlank(message= "La categoria es obligatoria")
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