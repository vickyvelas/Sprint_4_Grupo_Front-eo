package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.UnidadMedida;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl <UnidadMedida, Long> implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, UnidadMedidaRepository unidadMedidaRepository) {
        super(baseRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }

    @Override
    public List<UnidadMedida> search(String filtro) throws Exception {
        try {
            //List<UnidadMedida> unidadMedidas = unidadMedidaRepository.findByDenominacionContainingOrAbreviaturaContaining(filtro, filtro);
            //List<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro);
            List<UnidadMedida> unidadMedidas = unidadMedidaRepository.searchNativo(filtro);
            return unidadMedidas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<UnidadMedida> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.findByDenominacionContainingOrAbreviaturaContaining(filtro, filtro, pageable);
            //Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.search(filtro, pageable);
            Page<UnidadMedida> unidadMedidas = unidadMedidaRepository.searchNativo(filtro, pageable);
            return unidadMedidas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
