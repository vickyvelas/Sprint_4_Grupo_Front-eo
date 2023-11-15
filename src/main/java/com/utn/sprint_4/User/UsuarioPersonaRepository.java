package com.utn.sprint_4.User;

import com.utn.sprint_4.repositorios.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioPersonaRepository extends BaseRepository<UsuarioPersona, Long> {
    Optional<UsuarioPersona> findByUsername(String username);
}
