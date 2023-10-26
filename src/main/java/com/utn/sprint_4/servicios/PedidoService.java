package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PedidoService extends BaseService<Pedido,Long>{
    List<Pedido> searchFpago(String filtro) throws Exception;
    Page<Pedido> searchFpagoPageable(String filtro, Pageable pageable) throws Exception;
    List<Pedido> searchID(int filtro) throws Exception;
    Page<Pedido> searchIDPageable(int filtro, Pageable pageable) throws Exception;


}
