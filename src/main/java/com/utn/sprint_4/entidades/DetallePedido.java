package com.utn.sprint_4.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetallePedido extends Base {

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private Integer subtotal;

    @NotNull
    @Column(name = "subtotal_costo", precision = 10, scale = 2)
    private Integer subtotal_costo;

    //Relacion Pedido-1------n->DetallePedido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    //Relacion DetallePedido -1-------1->ArticuloManufacturado
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ArticuloManufacturado")
    private ArticuloManufacturado articuloManufacturado;
}
