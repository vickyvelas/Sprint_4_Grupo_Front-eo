package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Base;
import com.utn.sprint_4.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {

    List<Cliente> search(String filtro) throws Exception;

    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;

}
