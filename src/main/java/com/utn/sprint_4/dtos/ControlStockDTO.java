package com.utn.sprint_4.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControlStockDTO {

    private String nombre;
    private String denominacion;
    private String abreviatura;
    private int stockMinimo;
    private int stockActual;
    private int diferenciaStock;
}
