package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Factura;
import com.utn.sprint_4.enumeraciones.FormaPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface FacturaService extends BaseService<Factura, Long>{

    List<Factura> search(String paymenttype, String preferenceid, Long paymentid, BigDecimal totalventa, FormaPago formapago,Long merchantorder) throws Exception;

    Page<Factura> search(String paymenttype, String preferenceid, Long paymentid,BigDecimal totalventa, FormaPago formapago,Long merchantorder, Pageable pageable) throws Exception;

}

