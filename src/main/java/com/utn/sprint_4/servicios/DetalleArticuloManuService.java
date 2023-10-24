package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DetalleArticuloManuService extends BaseService<DetalleArticuloManufacturado, Long>{

    List<DetalleArticuloManufacturado> search(int filtro) throws Exception;

    //con paginacion
    Page<DetalleArticuloManufacturado> search(int filtro, Pageable pageable) throws Exception;

}