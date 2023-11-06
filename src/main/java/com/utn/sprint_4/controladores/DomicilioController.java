package com.utn.sprint_4.controladores;

import com.utn.sprint_4.entidades.Domicilio;
import com.utn.sprint_4.servicios.DomicilioServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(String calle, Number numero, Number codigoPostal, String localidad, Number numeroDpto, Number pisoDpto, Date fechaAlta, Date fechaModificacion, Date fechaBaja){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(calle, numero, codigoPostal, localidad, numeroDpto, pisoDpto, fechaAlta, fechaModificacion, fechaBaja));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(String calle, Number numero, Number codigoPostal, String localidad, Number numeroDpto, Number pisoDpto, Date fechaAlta, Date fechaModificacion, Date fechaBaja, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(calle, numero, codigoPostal, localidad, numeroDpto, pisoDpto, fechaAlta, fechaModificacion, fechaBaja, pageable));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
