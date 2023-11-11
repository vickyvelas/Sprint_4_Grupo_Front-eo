package com.utn.sprint_4.dtos;

import com.utn.sprint_4.enumeraciones.Rol;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DTOLogin {

    String nombre;
    String apellido;
    String telefono;
    Rol rol;


}
