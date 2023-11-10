package com.utn.sprint_4.entidades;

import com.utn.sprint_4.enumeraciones.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Persona extends Base {

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "nombre")
    @Temporal(TemporalType.TIMESTAMP)
    private String nombre;

    @Column(name = "apellido")
    @Temporal(TemporalType.TIMESTAMP)
    private String apellido;

    @Column(name = "email")
    @Temporal(TemporalType.TIMESTAMP)
    private String email;

    @Column(name = "telefono")
    @Temporal(TemporalType.TIMESTAMP)
    private String telefono;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @Column(name = "rol")
    @Temporal(TemporalType.TIMESTAMP)
    private Rol rol;

    //Relacion Persona -1-------1-> Usuario
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    //Relacion Persona -1-------n-> Pedido
    @OneToMany(mappedBy = "persona",cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    //Relacion Persona -1-----n->Domicilio
    @OneToMany(mappedBy = "persona",cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void AgregarPedidos(Pedido p){
        pedidos.add(p);
    }

    public void AgregarDomicilios(Domicilio d){
        domicilios.add(d);
    }
}
