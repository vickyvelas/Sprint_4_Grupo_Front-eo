package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Factura;
import com.utn.sprint_4.enumeraciones.FormaPago;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura,Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;


    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> search(String paymenttype, String preferenceid, Long paymentid, BigDecimal totalventa, FormaPago formapago, Long merchantorder) throws Exception {
        try{
            List<Factura> facturas = facturaRepository.searchNativo(paymenttype,preferenceid,paymentid,totalventa,formapago,merchantorder);
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Factura> search(String paymenttype, String preferenceid, Long paymentid, BigDecimal totalventa, FormaPago formapago,Long merchantorder, Pageable pageable) throws Exception {
        try{
            Page<Factura> facturas = facturaRepository.searchNativo(paymenttype,preferenceid,paymentid,totalventa,formapago,merchantorder, pageable);
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
