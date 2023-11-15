package com.utn.sprint_4.User;

import com.utn.sprint_4.controladores.BaseControllerImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v2/personas")
public class UsuarioPersonaController extends BaseControllerImpl<UsuarioPersona, UsuarioPersonaServiceImpl> {


}
