package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleFacturaService extends BaseService<DetalleFactura, Long>{
    List<DetalleFactura> search(int filtro) throws Exception;

    Page<DetalleFactura> search(int filtro, Pageable pageable) throws Exception;
}
