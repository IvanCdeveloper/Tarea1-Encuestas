package com.example.tarea1_ivancuarteros.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message= "Este campo es obligatorio")
    @Pattern(regexp = "^(?=\\S*\\S)(?!\\s).{2,}$", message = "Debes ingresar al menos dos caracteres no espacios en blanco")
    private String nombre;
    @NotNull(message= "Este campo es obligatorio")
    @Pattern(regexp = "^(?=\\S*\\S)(?!\\s).{2,}$", message = "Debes ingresar al menos dos caracteres no espacios en blanco")
    private String apellidos;
    @NotNull(message= "Este campo es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;
    @Min(value = 18, message = "La edad debe ser mayor o igual a 18 años")
    @NotNull(message= "Este campo es obligatorio")
    private int edad;
    @NotNull(message= "Este campo es obligatorio")
    private String telefono;
    @PastOrPresent(message = "La fecha debe de ser anterior al dia de hoy")
    @NotNull(message= "Este campo es obligatorio")
    private LocalDate fechaInicio;

    private String motivo;
    @NotNull(message= "Este campo es obligatorio")
    private String servicios;

    private String satisfacción;
    @NotNull(message= "Este campo es obligatorio")
    private String comentarios;

    public Encuesta(Long id, String nombre, String apellidos, String correo, int edad, String telefono, LocalDate fechaInicio, String motivo, String servicios, String satisfacción, String comentarios) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.motivo = motivo;
        this.servicios = servicios;
        this.satisfacción = satisfacción;
        this.comentarios = comentarios;
    }

    public Encuesta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Este campo es obligatorio") @Pattern(regexp = "^(?=\\S*\\S)(?!\\s).{2,}$", message = "Debes ingresar al menos dos caracteres no espacios en blanco") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull(message = "Este campo es obligatorio") @Pattern(regexp = "^(?=\\S*\\S)(?!\\s).{2,}$", message = "Debes ingresar al menos dos caracteres no espacios en blanco") String nombre) {
        this.nombre = nombre;
    }

    public @NotNull(message = "Este campo es obligatorio") @Pattern(regexp = "^(?=\\S*\\S)(?!\\s).{2,}$", message = "Debes ingresar al menos dos caracteres no espacios en blanco") String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NotNull(message = "Este campo es obligatorio") @Pattern(regexp = "^(?=\\S*\\S)(?!\\s).{2,}$", message = "Debes ingresar al menos dos caracteres no espacios en blanco") String apellidos) {
        this.apellidos = apellidos;
    }

    public @NotNull(message = "Este campo es obligatorio") @Email(message = "El formato del correo electrónico no es válido") String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotNull(message = "Este campo es obligatorio") @Email(message = "El formato del correo electrónico no es válido") String correo) {
        this.correo = correo;
    }

    @Min(value = 18, message = "La edad debe ser mayor o igual a 18 años")
    @NotNull(message = "Este campo es obligatorio")
    public int getEdad() {
        return edad;
    }

    public void setEdad(@Min(value = 18, message = "La edad debe ser mayor o igual a 18 años") @NotNull(message = "Este campo es obligatorio") int edad) {
        this.edad = edad;
    }

    public @NotNull(message = "Este campo es obligatorio") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotNull(message = "Este campo es obligatorio") String telefono) {
        this.telefono = telefono;
    }

    public @PastOrPresent(message = "La fecha debe de ser anterior al dia de hoy") @NotNull(message = "Este campo es obligatorio") LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(@PastOrPresent(message = "La fecha debe de ser anterior al dia de hoy") @NotNull(message = "Este campo es obligatorio") LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public @NotNull(message = "Este campo es obligatorio") String getServicios() {
        return servicios;
    }

    public void setServicios(@NotNull(message = "Este campo es obligatorio") String servicios) {
        this.servicios = servicios;
    }

    public String getSatisfacción() {
        return satisfacción;
    }

    public void setSatisfacción(String satisfacción) {
        this.satisfacción = satisfacción;
    }

    public @NotNull(message = "Este campo es obligatorio") String getComentarios() {
        return comentarios;
    }

    public void setComentarios(@NotNull(message = "Este campo es obligatorio") String comentarios) {
        this.comentarios = comentarios;
    }
}
