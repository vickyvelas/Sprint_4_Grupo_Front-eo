package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Base;
import com.utn.sprint_4.entidades.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {

    List<Cliente> search(String nombre,String apellido, String email,String telefono) throws Exception;

    Page<Cliente> search(String nombre,String apellido, String email,String telefono, Pageable pageable) throws Exception;



}
