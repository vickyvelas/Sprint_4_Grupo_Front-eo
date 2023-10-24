package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleArtManufacturadoRepository extends BaseRepository<DetalleArticuloManufacturado, Long>{

    List<DetalleArticuloManufacturado> findByCantidad(int cantidad);

    Page<DetalleArticuloManufacturado> findByCantidad(int cantidad, Pageable pageable);


    @Query(value = "Select f FROM DetalleArticuloManufacturado f WHERE f.cantidad =:filtro")
    List<DetalleArticuloManufacturado> search(@Param("filtro") int filtro);

    @Query(value = "Select f FROM DetalleArticuloManufacturado f WHERE f.cantidad =:filtro")
    Page<DetalleArticuloManufacturado> search(@Param("filtro") int filtro, Pageable pageable);

    @Query(value = "Select * FROM DetalleArticuloManufacturado WHERE f.cantidad =:filtro",
            nativeQuery = true
    )
    List<DetalleArticuloManufacturado> searchNativo(@Param("filtro")  int filtro);

    @Query(value = "Select * FROM DetalleArticuloManufacturado WHERE f.cantidad =:filtro",
            countQuery = "SELECT count(*) FROM detalleArticuloManufacturado",
            nativeQuery = true
    )
    Page<DetalleArticuloManufacturado> searchNativo(@Param("filtro") int filtro, Pageable pageable);

}

