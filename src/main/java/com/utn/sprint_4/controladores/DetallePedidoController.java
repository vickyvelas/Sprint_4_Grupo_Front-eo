package com.utn.sprint_4.controladores;

import com.utn.sprint_4.entidades.DetallePedido;
import com.utn.sprint_4.servicios.DetallePedidoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam int filtro, int subtotal, int subtotal_costo) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, subtotal, subtotal_costo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    //con paginacion
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam int filtro, int subtotal, int subtotal_costo, Pageable pageable) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, subtotal, subtotal_costo, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}
