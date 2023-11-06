package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Domicilio;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio,Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;


    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository) {

        super(baseRepository);
    }

    @Override
    public List<Domicilio> search(String calle, Number numero, Number codigoPostal, String localidad, Number numeroDpto, Number pisoDpto, Date fechaAlta, Date fechaModificacion, Date fechaBaja) throws Exception {
        try {
            List<Domicilio> domicilios = domicilioRepository.search(calle, numero, codigoPostal, localidad, numeroDpto, pisoDpto, fechaAlta, fechaModificacion, fechaBaja);
            return domicilios;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> search(String calle, Number numero, Number codigoPostal, String localidad, Number numeroDpto, Number pisoDpto, Date fechaAlta, Date fechaModificacion, Date fechaBaja, Pageable pageable) throws Exception {
        try {
            Page<Domicilio> domicilios = domicilioRepository.searchNativo(calle, numero, codigoPostal, localidad, numeroDpto, pisoDpto, fechaAlta, fechaModificacion, fechaBaja, pageable);
            return domicilios;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
