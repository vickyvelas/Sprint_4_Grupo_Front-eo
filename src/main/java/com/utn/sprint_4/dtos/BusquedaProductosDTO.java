package com.utn.sprint_4.dtos;

import com.utn.sprint_4.entidades.ArticuloManufacturado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusquedaProductosDTO {

    private String denominacion;

    private String descripcion;

    private Integer tiempoEstimadoCocina;

    private int precioVenta;

    private int costo;

    private String urlImagen;

}
