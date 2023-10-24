package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long>{

    List<DetallePedido> findByCantidad(int cantidad);

    Page<DetallePedido> findByCantidad(int cantidad, Pageable pageable);


    @Query(value = "Select f FROM DetallePedido f WHERE f.cantidad =:filtro")
    List<DetallePedido> search(@Param("filtro") int filtro);

    @Query(value = "Select f FROM DetallePedido f WHERE f.cantidad =:filtro")
    Page<DetallePedido> search(@Param("filtro") int filtro, Pageable pageable);

    @Query(value = "Select * FROM DetallePedido WHERE f.cantidad =:filtro",
            nativeQuery = true
    )
    List<DetallePedido> searchNativo(@Param("filtro")  int filtro);

    @Query(value = "Select * FROM DetallePedido WHERE f.cantidad =:filtro",
            countQuery = "SELECT count(*) FROM detallePedido",
            nativeQuery = true
    )
    Page<DetallePedido> searchNativo(@Param("filtro") int filtro, Pageable pageable);
}
