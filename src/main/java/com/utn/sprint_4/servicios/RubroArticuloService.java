package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.RubroArticulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RubroArticuloService extends BaseService<RubroArticulo,Long>{
    List<RubroArticulo> search(String filtro) throws Exception;

    Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception;

}
