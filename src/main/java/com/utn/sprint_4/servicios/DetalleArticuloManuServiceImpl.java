package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.DetalleArticuloManufacturado;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.DetalleArtManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleArticuloManuServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManuService {

    @Autowired
    private DetalleArtManufacturadoRepository detalleArtManufacturadoRepository;

    public DetalleArticuloManuServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
        this.detalleArtManufacturadoRepository = detalleArtManufacturadoRepository;
    }

    @Override
    public List<DetalleArticuloManufacturado> search(int filtro) throws Exception {
        try {
            List<DetalleArticuloManufacturado> articuloManufacturados = detalleArtManufacturadoRepository.searchNativo(filtro);
            return articuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //con paginacion
    @Override
    public Page<DetalleArticuloManufacturado> search(int filtro, Pageable pageable) throws Exception {
        try {
            Page<DetalleArticuloManufacturado> articuloManufacturados = detalleArtManufacturadoRepository.searchNativo(filtro, pageable);
            return articuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}