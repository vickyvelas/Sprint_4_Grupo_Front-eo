package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long>{
    @Query(value = "SELECT * FROM articuloInsumo WHERE articuloInsumo.denominacion LIKE %:filtro% ",
            nativeQuery = true)
    List<ArticuloInsumo> searchNativo(@Param("filtro") String filtro);
    @Query(value = "SELECT * FROM articuloInsumo WHERE articuloInsumo.denominacion LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM articuloInsumo",
            nativeQuery = true)
    Page<ArticuloInsumo> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
