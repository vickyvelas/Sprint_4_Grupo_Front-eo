package com.utn.sprint_4.User;

import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.servicios.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioPersonaServiceImpl extends BaseServiceImpl<UsuarioPersona, Long> implements UsuarioPersonaService {

    @Autowired
    private UsuarioPersonaRepository usuarioPersonaRepository;


    public UsuarioPersonaServiceImpl(BaseRepository<UsuarioPersona, Long> baseRepository) {
        super(baseRepository);
        this.usuarioPersonaRepository = usuarioPersonaRepository;
    }
}
