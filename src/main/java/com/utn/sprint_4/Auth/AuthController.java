package com.utn.sprint_4.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping(value = "login")
    public String login(){
        return "Te has logueado bien";
    }

    @PostMapping(value = "register")
    public String register(){
        return "Te has registrado bien";
    }


}
