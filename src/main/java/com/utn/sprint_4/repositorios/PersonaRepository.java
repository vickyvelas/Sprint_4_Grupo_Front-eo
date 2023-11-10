package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{




    @Query(value = "Select c FROM Persona c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.telefono LIKE %:telefono%")
    List<Persona> search(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono);

    @Query(value = "Select c FROM Persona c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.telefono LIKE %:telefono%")
    Page<Persona> search(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono, Pageable pageable);


    @Query(value = "Select * FROM cliente WHERE cliente.nombre LIKE %:nombre% AND cliente.apellido LIKE %:apellido% AND cliente.telefono LIKE %:telefono%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono);

    @Query(value = "Select * FROM Persona WHERE cliente.nombre LIKE %:nombre% OR cliente.apellido LIKE %:apellido% OR cliente.telefono LIKE %:telefono%",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono, Pageable pageable);


}



