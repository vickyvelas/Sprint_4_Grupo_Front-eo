package com.utn.sprint_4.controladores;

import com.utn.sprint_4.entidades.Usuario;
import com.utn.sprint_4.servicios.UsuarioServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @GetMapping("/login")
    public ResponseEntity<?> login(String email, String password){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.login(email, password));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }
}


