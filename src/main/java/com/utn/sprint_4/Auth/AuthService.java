package com.utn.sprint_4.Auth;

import com.utn.sprint_4.JWT.JwtService;
import com.utn.sprint_4.User.*;
import com.utn.sprint_4.entidades.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UsuarioPersonaRepository usuarioPersonaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();


    }

    public AuthResponse registerUser(UserRegisterRequest request) {

        UsuarioPersona persona = UsuarioPersona.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .telefono(request.getTelefono())
                .password(passwordEncoder.encode(request.getPassword()))
                .repeatPassword(passwordEncoder.encode(request.getRepeatPassword()))
                .email(request.getEmail())
                .direccion(request.getDireccion())
                .departamento(request.getDepartamento())
                .fechaNacimiento(request.getFechaNacimiento())
                .role(Role.USER)
                .build();

        usuarioPersonaRepository.save(persona);

        return AuthResponse.builder()
                .token(jwtService.getToken(persona))
                .build();


    }
}
