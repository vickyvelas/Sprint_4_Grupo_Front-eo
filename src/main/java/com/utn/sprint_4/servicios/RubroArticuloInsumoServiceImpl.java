package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.RubroArticuloInsumo;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.RubroArticuloInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloInsumoServiceImpl extends BaseServiceImpl<RubroArticuloInsumo, Long> implements RubroArticuloInsumoService {
    @Autowired
    private RubroArticuloInsumoRepository rubroArticuloInsumoRepository;

    public RubroArticuloInsumoServiceImpl(BaseRepository<RubroArticuloInsumo, Long> baseRepository){
        super(baseRepository);
        this.rubroArticuloInsumoRepository = rubroArticuloInsumoRepository;
    }

    @Override
    public List<RubroArticuloInsumo> search(String filtro) throws Exception {
        try{
            List<RubroArticuloInsumo> rubroArticuloInsumos = rubroArticuloInsumoRepository.searchNativo(filtro);
            return rubroArticuloInsumos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<RubroArticuloInsumo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<RubroArticuloInsumo> rubroArticuloInsumos = rubroArticuloInsumoRepository.searchNativo(filtro, pageable);
            return rubroArticuloInsumos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
