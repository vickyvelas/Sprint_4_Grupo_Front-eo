package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.RubroArticuloInsumo;
import com.utn.sprint_4.entidades.RubroArticuloManufacturado;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.RubroArticuloInsumoRepository;
import com.utn.sprint_4.repositorios.RubroArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloManufacturadoServiceImpl extends BaseServiceImpl<RubroArticuloManufacturado, Long> implements RubroArticuloManufacturadoService {
    @Autowired
    private RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository;

    public RubroArticuloManufacturadoServiceImpl(BaseRepository<RubroArticuloManufacturado, Long> baseRepository){
        super(baseRepository);
        this.rubroArticuloManufacturadoRepository = rubroArticuloManufacturadoRepository;
    }

    @Override
    public List<RubroArticuloManufacturado> search(String filtro) throws Exception {
        try{
            List<RubroArticuloManufacturado> rubroArticuloManufacturados = rubroArticuloManufacturadoRepository.searchNativo(filtro);
            return rubroArticuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<RubroArticuloManufacturado> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<RubroArticuloManufacturado> rubroArticuloManufacturados = rubroArticuloManufacturadoRepository.searchNativo(filtro, pageable);
            return rubroArticuloManufacturados;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
