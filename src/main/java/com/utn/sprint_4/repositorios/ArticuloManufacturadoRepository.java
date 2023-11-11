package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.dtos.DTORankingProductos;
import com.utn.sprint_4.entidades.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long>{

    List<DTORankingProductos> findBy();

    @Query(value = "SELECT * FROM Articulo_Manufacturado WHERE Articulo_Manufacturado.denominacion LIKE %:denominacion% ",
            nativeQuery = true)
    List<ArticuloManufacturado> searchNativo(@Param("denominacion") String denominacion);
    List<ArticuloManufacturado> findByDenominacion(@Param("denominacion") String denominacion);


    
    @Query(value = "SELECT * FROM Articulo_Manufacturado WHERE Articulo_Manufacturado.denominacion LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM Articulo_Manufacturado",
            nativeQuery = true)
    Page<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);



}
