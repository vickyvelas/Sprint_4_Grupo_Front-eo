package com.utn.sprint_4.servicios;

import com.utn.sprint_4.dtos.PersonaDTO;
import com.utn.sprint_4.dtos.RankingPersonasDTO;
import com.utn.sprint_4.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonaService extends BaseService<Persona, Long> {

    List<RankingPersonasDTO> rankingPersonas(Date fechaInicio, Date fechaFin) throws Exception;

    List<Persona> search(String nombre, String apellido, String telefono) throws Exception;

    PersonaDTO search(String user, String pass) throws Exception;

    Page<Persona> search(String nombre, String apellido, String telefono, Pageable pageable) throws Exception;


}
