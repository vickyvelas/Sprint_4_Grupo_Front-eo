package com.utn.sprint_4.controladores;

import com.utn.sprint_4.entidades.ArticuloInsumo;
import com.utn.sprint_4.servicios.ArticuloInsumoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins =  "*")
@RequestMapping(path = "api/v1/ArticuloInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl>{
    @GetMapping("/search")
    public ResponseEntity<?> search( String denominacion, Number min, Number max, Number stockMenor, Number minStock, Number maxStock){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(denominacion,min,max,stockMenor,minStock,maxStock));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(String denominacion, Number min, Number max, Number stockMenor, Number minStock, Number maxStock, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(denominacion,min,max,stockMenor,minStock,maxStock, pageable));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
