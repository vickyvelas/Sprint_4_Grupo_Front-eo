package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida, Long>{

    @Query(value = "Select * FROM Unidad_Medida WHERE Unidad_Medida.denominacion LIKE %:filtro% OR Unidad_Medida.abreviatura LIKE %:filtro% ",
            nativeQuery = true
    )
    List<UnidadMedida> searchNativo(@Param("filtro")  String filtro);

    @Query(value = "Select * FROM Unidad_Medida WHERE Unidad_Medida.denominacion LIKE %:filtro% OR Unidad_Medida.abreviatura LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM Unidad_Medida",
            nativeQuery = true
    )
    Page<UnidadMedida> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}


