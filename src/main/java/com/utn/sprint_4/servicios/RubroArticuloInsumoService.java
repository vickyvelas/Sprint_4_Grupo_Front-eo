package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.RubroArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloInsumoService extends BaseService<RubroArticuloInsumo,Long>{
    List<RubroArticuloInsumo> search(String filtro) throws Exception;

    Page<RubroArticuloInsumo> search(String filtro, Pageable pageable) throws Exception;

}
