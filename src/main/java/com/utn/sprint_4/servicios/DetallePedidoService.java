package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.DetallePedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetallePedidoService extends BaseService<DetallePedido, Long>{
    List<DetallePedido> search(int filtro, int subtotal, int subtotal_costo) throws Exception;

    //con paginacion
    Page<DetallePedido> search(int filtro, int subtotal, int subtotal_costo, Pageable pageable) throws Exception;
}
