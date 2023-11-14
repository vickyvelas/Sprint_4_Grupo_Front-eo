package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.RubroArticuloInsumo;
import com.utn.sprint_4.entidades.RubroArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloManufacturadoService extends BaseService<RubroArticuloManufacturado,Long>{
    List<RubroArticuloManufacturado> search(String filtro) throws Exception;

    Page<RubroArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception;

}
