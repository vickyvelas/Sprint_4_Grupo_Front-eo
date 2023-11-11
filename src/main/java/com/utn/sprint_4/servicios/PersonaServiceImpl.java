package com.utn.sprint_4.servicios;

import com.utn.sprint_4.dtos.DTOLogin;
import com.utn.sprint_4.entidades.Persona;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> search(String nombre, String apellido, String telefono) throws Exception {
        try{
            //   List<Persona> personas= personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //   List<Persona> personas = personaRepository.search(filtro);
            List<Persona> personas = personaRepository.searchNativo(nombre, apellido, telefono);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String nombre, String apellido, String telefono, Pageable pageable) throws Exception {
        try{
            //   Page<Persona> clientes= personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //   Page<Persona> clientes = personaRepository.search(filtro, pageable);
            Page<Persona> clientes = personaRepository.searchNativo(nombre, apellido, telefono, pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    //METODO PARA LOGIN HISTORIA 1 (TE BUSCA UN USUARIO POR USERNAME Y CONTRASEÑA Y TE TRAE SUS DATOS)
    @Override
    public DTOLogin login(String email, String password) throws Exception{
        try{
            Persona persona = personaRepository.login(email, password);
            DTOLogin personaDTO = new DTOLogin(persona.getNombre(), persona.getApellido(), persona.getTelefono(), persona.getRol());
            return personaDTO;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
