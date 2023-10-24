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

    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);


    @Query(value = "Select c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro% ")
    List<Cliente> search(@Param("filtro") String filtro);

    @Query(value = "Select c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.apellido LIKE %:filtro% ")
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "Select * FROM Cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro")  String filtro);

    @Query(value = "Select * FROM Cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}



