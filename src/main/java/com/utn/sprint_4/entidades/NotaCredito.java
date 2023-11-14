package com.utn.sprint_4.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "nota_credito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NotaCredito extends Base{

    private int montoTotal;

    private String motivoAnulacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Persona persona;

    //Relacion Factura -1-------1-> NotaCredito
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;

}
