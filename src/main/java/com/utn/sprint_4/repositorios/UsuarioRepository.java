package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Persona;
import com.utn.sprint_4.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{

    @Query(value = "Select * FROM Usuario AND Persona WHERE Usuario.email LIKE %:email% AND Usuario.password LIKE %:password%",
            nativeQuery = true)
    Persona login(@Param("email") String email, @Param("password") String password);
}



