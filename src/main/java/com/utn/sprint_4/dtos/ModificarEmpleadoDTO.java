package com.utn.sprint_4.dtos;

import com.utn.sprint_4.enumeraciones.Rol;
import jakarta.persistence.Entity;

public class ModificarEmpleadoDTO {
    private String nombre;
    private String apellido;
    private String telefono;
    private String legajo;
    private Rol rol;

    public ModificarEmpleadoDTO(String nombre, String apellido, String telefono, Rol rol, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.legajo = legajo;
    }

    public ModificarEmpleadoDTO() {
    }

    public String getLegajo() {
        return legajo;
    }

    public String getNombreDTO() {
        return nombre;
    }

    public String getApellidoDTO() {
        return apellido;
    }

    public String getTelefonoDTO() {
        return telefono;
    }

    public Rol getRolDTO() {
        return rol;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

}
