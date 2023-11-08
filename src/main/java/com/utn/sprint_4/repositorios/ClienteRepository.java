package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{

    /*List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);*/


    @Query(value = "Select c FROM Cliente c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.email LIKE %:email% OR c.telefono LIKE %:telefono%")
    List<Cliente> search(@Param("nombre")  String nombre,@Param("apellido")String apellido,@Param("email")String email,@Param("telefono")String telefono);

    @Query(value = "Select c FROM Cliente c WHERE c.nombre LIKE %:nombre% OR c.apellido LIKE %:apellido% OR c.email LIKE %:email% OR c.telefono LIKE %:telefono%")
    Page<Cliente> search(@Param("nombre")  String nombre,@Param("apellido")String apellido,@Param("email")String email,@Param("telefono")String telefono, Pageable pageable);


    @Query(value = "Select * FROM cliente WHERE cliente.nombre LIKE %:nombre% AND cliente.apellido LIKE %:apellido% AND cliente.email LIKE %:email% AND cliente.telefono LIKE %:telefono%",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("nombre")  String nombre,@Param("apellido")String apellido,@Param("email")String email,@Param("telefono")String telefono);

    @Query(value = "Select * FROM Cliente WHERE cliente.nombre LIKE %:nombre% OR cliente.apellido LIKE %:apellido% OR cliente.email LIKE %:email% OR cliente.telefono LIKE %:telefono%",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(@Param("nombre")  String nombre,@Param("apellido")String apellido,@Param("email")String email,@Param("telefono")String telefono, Pageable pageable);


}



