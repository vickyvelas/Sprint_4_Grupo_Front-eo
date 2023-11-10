package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Persona;
import com.utn.sprint_4.entidades.Usuario;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, UsuarioRepository usuarioRepository) {
        super(baseRepository);
        this.usuarioRepository = usuarioRepository;
    }

    //METODO PARA LOGIN HISTORIA 1 (TE BUSCA UN USUARIO POR USERNAME Y CONTRASEÑA)
    @Override
    public Persona login(String email, String password) throws Exception{
        try{
            Persona persona = usuarioRepository.login(email, password);
            return persona;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
