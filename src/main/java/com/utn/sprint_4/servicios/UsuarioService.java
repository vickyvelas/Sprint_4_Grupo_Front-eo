package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Persona;
import com.utn.sprint_4.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long> {
    Persona login(String email, String password) throws Exception;
}
