package com.utn.sprint_4.dtos;

import com.utn.sprint_4.entidades.ArticuloManufacturado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusquedaProductosDTO {

    private String denominacion;
    private String descripcion;
    private int precioVenta;
    private String urlImagen;

    public BusquedaProductosDTO (String denominacion, String descripcion, int precioVenta, String urlImagen){
        this.denominacion = denominacion;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.urlImagen = urlImagen;
    }



}
