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


    @Query(value = "Select f FROM DetallePedido f WHERE f.cantidad =:filtro OR f.subtotal =:subtotal OR f.subtotal_costo =:subtotal_costo")
    List<DetallePedido> search(@Param("filtro") int filtro, @Param("subtotal") int subtotal, @Param("subtotal_costo") int subtotal_costo);

    @Query(value = "Select f FROM DetallePedido f WHERE f.cantidad =:filtro OR f.subtotal =:subtotal OR f.subtotal_costo =:subtotal_costo")
    Page<DetallePedido> search(@Param("filtro") int filtro,  @Param("subtotal") int subtotal, @Param("subtotal_costo") int subtotal_costo, Pageable pageable);

    @Query(value = "Select * FROM DetallePedido WHERE detallePedido.cantidad =:filtro OR detallePedido.subtotal =:subtotal OR detallePedido.subtotal_costo =:subtotal_costo",
            nativeQuery = true
    )
    List<DetallePedido> searchNativo(@Param("filtro")  int filtro,  @Param("subtotal") int subtotal, @Param("subtotal_costo") int subtotal_costo);

    @Query(value = "Select * FROM DetallePedido WHERE detallePedido.cantidad =:filtro OR detallePedido.subtotal =:subtotal OR detallePedido.subtotal_costo =:subtotal_costo",
            countQuery = "SELECT count(*) FROM detallePedido",
            nativeQuery = true
    )
    Page<DetallePedido> searchNativo(@Param("filtro") int filtro,  @Param("subtotal") int subtotal, @Param("subtotal_costo") int subtotal_costo, Pageable pageable);
}
