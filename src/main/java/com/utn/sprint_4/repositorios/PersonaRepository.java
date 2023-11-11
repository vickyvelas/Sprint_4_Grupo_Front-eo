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

    //--------------IGNORAR-------------------------
    @Query(value = "Select * FROM Persona", nativeQuery = true)
    Persona prueba();
    /*SELECT PERSONA .nombre, PERSONA .apellido, PERSONA .telefono, PERSONA .rol FROM PERSONA LEFT JOIN USUARIO ON PERSONA.ID_USUARIO = USUARIO.ID WHERE USUARIO.email LIKE '%yoSoyDeBoca@gmail.com%' AND USUARIO.password LIKE '%1234ABCD?%'*/








    @Query(value = "Select c FROM Persona c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.telefono LIKE %:telefono%")
    List<Persona> search(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono);

    @Query(value = "Select c FROM Persona c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.telefono LIKE %:telefono%")
    Page<Persona> search(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono, Pageable pageable);


    @Query(value = "Select * FROM Persona WHERE Persona.nombre LIKE %:nombre% AND Persona.apellido LIKE %:apellido% AND Persona.telefono LIKE %:telefono%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono);

    @Query(value = "Select * FROM Persona WHERE cliente.nombre LIKE %:nombre% OR cliente.apellido LIKE %:apellido% OR cliente.telefono LIKE %:telefono%",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("nombre")  String nombre, @Param("apellido")String apellido, @Param("telefono")String telefono, Pageable pageable);

    @Query(value = "SELECT * FROM PERSONA  WHERE PERSONA.ID_USUARIO=(SELECT ID FROM USUARIO WHERE USUARIO.USERNAME LIKE %:user% AND USUARIO.PASSWORD LIKE %:pass%)",
            nativeQuery = true
    )
    Persona searchNativo(@Param("user") String user, @Param("pass") String pass);


}



