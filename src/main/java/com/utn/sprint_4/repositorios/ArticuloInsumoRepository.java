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


    @Query(value = "SELECT * FROM articulo_insumo", nativeQuery = true)
    List<ArticuloInsumo> controlStockInsuficiente();

    @Query(value = "SELECT * FROM articulo_insumo", nativeQuery = true)
    List<ArticuloInsumo> controlStockBajo();

    @Query(value = "SELECT * FROM articulo_insumo a WHERE a.denominacion LIKE %:denominacion% OR a.precio_compra>=%:min% OR a.precio_compra<%:max% OR a.stock_minimo<=%:stockMenor% OR a.stock_actual<%:minStock% OR a.stock_actual>=%:maxStock%",
            nativeQuery = true)
    List<ArticuloInsumo> searchNativo(@Param("denominacion") String denominacion, @Param("min") Number min, @Param("max") Number max, @Param("stockMenor") Number stockMenor, @Param("minStock") Number minStock, @Param("maxStock") Number maxStock);
    @Query(value = "SELECT * FROM articulo_insumo a WHERE a.denominacion LIKE %:denominacion% OR a.precio_compra>=%:min% OR a.precio_compra<%:max% OR a.stock_minimo<=%:stockMenor% OR a.stock_actual<%:minStock% OR a.stock_actual>=%:maxStock%",
            countQuery = "SELECT count(*) FROM articuloInsumo",
            nativeQuery = true)
    Page<ArticuloInsumo> searchNativo(@Param("denominacion") String denominacion, @Param("min") Number min, @Param("max") Number max, @Param("stockMenor") Number stockMenor, @Param("minStock") Number minStock, @Param("maxStock") Number maxStock, Pageable pageable);
}
