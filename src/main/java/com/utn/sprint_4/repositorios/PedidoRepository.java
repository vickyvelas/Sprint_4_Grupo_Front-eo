package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {
    @Query(value = "SELECT * FROM pedido WHERE pedido.forma_pago LIKE %:filtro% ",
            nativeQuery = true)
    List<Pedido> searchNativo(@Param("filtro") String filtro);
    @Query(value = "SELECT * FROM pedido WHERE pedido.forma_pago LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM pedido",
            nativeQuery = true)
    Page<Pedido> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}