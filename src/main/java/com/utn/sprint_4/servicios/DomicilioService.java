package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface DomicilioService extends BaseService<Domicilio, Long>{

    List<Domicilio> search(String calle, Number numero, Number codigoPostal, String localidad, Number numeroDpto, Number pisoDpto, Date fechaAlta, Date fechaModificacion, Date fechaBaja) throws Exception;
    Page<Domicilio> search(String calle, Number numero, Number codigoPostal, String localidad, Number numeroDpto, Number pisoDpto, Date fechaAlta, Date fechaModificacion, Date fechaBaja, Pageable pageable) throws Exception;
}
