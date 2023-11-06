package com.utn.sprint_4.repositorios;

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

    @Query(value = "Select u FROM Usuario u WHERE u.username LIKE %:filtro% OR u.auth0Id LIKE %:filtro% ")
    List<Usuario> search(@Param("filtro") String filtro);

    @Query(value = "Select u FROM Usuario u WHERE u.username LIKE %:filtro% OR u.auth0Id LIKE %:filtro% ")
    Page<Usuario> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(value = "Select * FROM Usuario WHERE usuario.username LIKE %:filtro% OR usuario.auth0Id LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Usuario> searchNativo(@Param("filtro")  String filtro);

    @Query(value = "Select * FROM Usuario WHERE usuario.username LIKE %:filtro% OR usuario.auth0Id LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM usuario",
            nativeQuery = true
    )
    Page<Usuario> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}



