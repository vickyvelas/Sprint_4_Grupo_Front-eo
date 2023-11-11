package com.utn.sprint_4.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

@Getter @Setter
public class PersonaDTO {

    String nombre;

    String apellido;

    public PersonaDTO (String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }

    public PersonaDTO (){
    }

}
