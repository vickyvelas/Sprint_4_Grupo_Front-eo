package com.utn.sprint_4.controladores;

import com.utn.sprint_4.entidades.Factura;
import com.utn.sprint_4.enumeraciones.FormaPago;
import com.utn.sprint_4.servicios.FacturaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search (String paymenttype, String preferenceid, Long paymentid, BigDecimal totalventa, FormaPago formapago, Long merchantorder){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(paymenttype,preferenceid,paymentid,totalventa,formapago,merchantorder));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search (String paymenttype, String preferenceid, Long paymentid, BigDecimal totalventa, FormaPago formapago,Long merchantorder, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(paymenttype,preferenceid,paymentid,totalventa,formapago,merchantorder,pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

}
