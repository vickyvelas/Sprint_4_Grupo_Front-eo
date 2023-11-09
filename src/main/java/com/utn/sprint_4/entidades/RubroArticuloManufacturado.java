package com.utn.sprint_4.entidades;

import com.utn.sprint_4.enumeraciones.Categoria;
import com.utn.sprint_4.enumeraciones.CategoriaM;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


import java.util.Date;

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


    }

