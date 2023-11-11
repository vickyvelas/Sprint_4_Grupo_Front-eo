package com.utn.sprint_4.dtos;

import com.utn.sprint_4.entidades.ArticuloManufacturado;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
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

    public BusquedaProductosDTO() {

    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
