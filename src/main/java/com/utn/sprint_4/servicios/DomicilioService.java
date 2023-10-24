package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long>{

    List<Domicilio> search(String filtro) throws Exception;
    Page<Domicilio> search(String filtro, Pageable pageable) throws Exception;
}
