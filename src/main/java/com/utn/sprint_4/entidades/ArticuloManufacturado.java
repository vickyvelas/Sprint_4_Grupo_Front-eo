package com.utn.sprint_4.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ArticuloManufacturado extends Base {

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private int precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private int costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    //Relacion DetallePedido -1-------1->ArticuloManufacturado
    @OneToOne(cascade = CascadeType.ALL)
    private DetallePedido detallePedido ;

    //Detalle ArticuloManufacturado-1------n->detalleArticuloManufacturado
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "articuloManufacturado")
    @NotNull
    @Builder.Default
    private List<DetalleArticuloManufacturado> detalleArticulosManufacturados = new ArrayList<>();


    public void AgregarDetalleArtManufac(DetalleArticuloManufacturado dam){
        detalleArticulosManufacturados.add(dam);
    }

    //Detalle ArticuloManufacturado-1------n->detalleFactura
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "articuloManufacturado")
    @NotNull
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();
    public void AgregarDetalleFactura(DetalleFactura df){
        detalleFacturas.add(df);
    }

}
