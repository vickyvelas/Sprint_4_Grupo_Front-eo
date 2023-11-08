package com.utn.sprint_4.controladores;

import com.utn.sprint_4.entidades.Persona;
import com.utn.sprint_4.servicios.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/clientes")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    @GetMapping("/search")
    public ResponseEntity<?> search (String nombre, String apellido,String email, String telefono){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(nombre, apellido, email, telefono));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search (String nombre, String apellido,String email, String telefono, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(nombre, apellido, email, telefono, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));

        }
    }




}
