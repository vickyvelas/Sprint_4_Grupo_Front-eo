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
    @Column(name = "fechaFacturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "paymentid")
    private Long paymentid;

    @Column(name = "merchantorder")
    private Long merchantorder;

    @Column(name = "preferenceid")
    private String preferenceid;

    @Column(name = "paymenttype")
    private String paymenttype;

    @NotNull
    @Column(name = "formapago")
    private FormaPago formapago;

    @NotNull
    @Column(name = "totalventa", precision = 10, scale = 2)
    private int totalventa;

    @NotNull
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fechaBaja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @NotNull
    @OneToOne()
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

}