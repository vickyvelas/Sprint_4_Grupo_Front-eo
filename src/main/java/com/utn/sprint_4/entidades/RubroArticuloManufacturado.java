/*

package com.utn.sprint_4.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rubro_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RubroArticuloManufacturado extends Base{

        @NotNull
        private String denominacion;

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

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "rubroArticuloManufacturado")
        @Builder.Default
        private List<ArticuloManufacturado> articulosManufacturados = new ArrayList<>();
        public void AgregararticulosManufacturados(ArticuloManufacturado am){
                articulosManufacturados.add(am);
        }



    }

*/