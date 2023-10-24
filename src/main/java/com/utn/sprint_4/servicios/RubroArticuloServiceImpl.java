package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.RubroArticulo;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService {
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository){
        super(baseRepository);
        this.rubroArticuloRepository=rubroArticuloRepository;
    }

    @Override
    public List<RubroArticulo> search(String filtro) throws Exception {
        try{
            List<RubroArticulo> rubroArticulos = rubroArticuloRepository.searchNativo(filtro);
            return rubroArticulos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<RubroArticulo> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<RubroArticulo> rubroArticulos = rubroArticuloRepository.searchNativo(filtro, pageable);
            return rubroArticulos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
