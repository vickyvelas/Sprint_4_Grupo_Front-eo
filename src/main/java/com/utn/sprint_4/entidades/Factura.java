package com.utn.sprint_4.entidades;


import com.utn.sprint_4.enumeraciones.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Factura extends Base {

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mpPreferenceId")
    private String mpPreferenceId;

    @Column(name = "mpPaymentType")
    private String mpPaymentType;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    @Column(name = "total_venta", precision = 10, scale = 2)
    private int totalVenta;

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

    @NotNull
    @OneToOne()
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}
