package com.utn.sprint_4.dtos;

import com.utn.sprint_4.entidades.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class RankingPersonasDTO {

    String personaNombre;
    Integer cantidadPedidos;
    int total;

    public RankingPersonasDTO(String personaNombre, Integer cantidadPedidos, int total) {
        this.personaNombre = personaNombre;
        this.cantidadPedidos = cantidadPedidos;
        this.total = total;
    }
}
