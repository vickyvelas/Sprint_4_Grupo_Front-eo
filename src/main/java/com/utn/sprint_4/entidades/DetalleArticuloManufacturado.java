package com.utn.sprint_4.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "detalle_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetalleArticuloManufacturado extends Base {

    @NotNull
    @Column(name = "cantidad", precision = 10, scale = 2)
    private int cantidad;

    //Relacion ArticuloManufacturado-1------n->DetalleArticuloManuf
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ArticuloManufacturadd")
    private ArticuloManufacturado articuloManufacturado;

    //Relacion ArticuloInsumo<-1------n-DetalleArticuloManuf
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ArticuloInsumo")
    private ArticuloInsumo articuloInsumo;

}
