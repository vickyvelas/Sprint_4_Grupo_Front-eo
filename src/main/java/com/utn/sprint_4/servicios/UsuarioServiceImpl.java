package com.utn.sprint_4.servicios;

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

    @Override
    public List<Usuario> search(String filtro) throws Exception {
        try {
            //List<Usuario> usuarios = usuarioRepository.findByUsernameContainingOrAuth0IdContaining(filtro, filtro);
            //List<Usuario> usuarios = usuarioRepository.search(filtro);
            List<Usuario> usuarios = usuarioRepository.searchNativo(filtro);
            return usuarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Usuario> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Usuario> usuarios = usuarioRepository.findByUsernameContainingOrAuth0IdContaining(filtro, filtro, pageable);
            //Page<Usuario> usuarios = usuarioRepository.search(filtro, pageable);
            Page<Usuario> usuarios = usuarioRepository.searchNativo(filtro, pageable);
            return usuarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
