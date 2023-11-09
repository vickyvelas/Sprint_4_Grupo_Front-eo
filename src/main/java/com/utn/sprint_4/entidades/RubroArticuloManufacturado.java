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
public class RubroArticuloManufacturado {
    public class RubroArticulo extends Base {

        @NotNull
        private String denominacion;

        @NotNull
        @Temporal(TemporalType.TIMESTAMP)
        private CategoriaM categoriaM; //Rubro "padre"

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


}
