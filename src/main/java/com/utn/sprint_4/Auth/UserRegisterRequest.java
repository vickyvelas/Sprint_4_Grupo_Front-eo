package com.utn.sprint_4.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    String firstname;
    String lastname;
    String username;
    int telefono;
    String password;
    String repeatPassword;
    String email;
    String direccion;
    String departamento;
    String fechaNacimiento;
}
