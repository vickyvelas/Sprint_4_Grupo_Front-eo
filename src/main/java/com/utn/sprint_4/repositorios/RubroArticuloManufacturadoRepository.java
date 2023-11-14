package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.RubroArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloManufacturadoRepository extends BaseRepository<RubroArticuloManufacturado, Long> {

    @Query(value = "Select * FROM Rubro_Articulo WHERE denominacion LIKE %:filtro% ",
            nativeQuery = true
    )
    List<RubroArticuloManufacturado> searchNativo(@Param("filtro") String filtro);

    @Query(value = "Select * FROM Rubro_Articulo WHERE denominacion LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM Rubro_Articulo",
            nativeQuery = true
    )
    Page<RubroArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}
