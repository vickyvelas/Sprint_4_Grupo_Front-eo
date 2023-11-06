package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio, Long>{

    @Query(value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE %:calle% OR domicilio.numero LIKE %:numero% OR domicilio.codigoPostal LIKE %:codigoPostal% OR domicilio.localidad LIKE %:localidad% OR domicilio.numeroDpto LIKE %:numeroDpto% " +
            "OR domiclio.pisoDpto  LIKE %:pisoDpto% OR domicilio.fechaAlta LIKE %:fechaAlta% OR domicilio.fechaModificacion LIKE %:fechaModificacion% OR domicilio.fechaBaja %:fechaBaja% ",
            nativeQuery = true)
    List<Domicilio> search(@Param("calle")  String calle, @Param("numero") Number numero, @Param("codigoPostal")Number codigoPostal, @Param("localidad")String localidad, @Param("numeroDpto") Number numeroDpto, @Param("pisoDpto") Number pisoDpto, @Param("fechaAlta") Date fechaAlta, @Param("fechaModificacion") Date fechaModificacion, @Param("fechaBaja") Date fechaBaja);

    @Query(value = "SELECT * FROM domicilio WHERE domicilio.calle LIKE %:calle% OR domicilio.numero LIKE %:numero% OR domicilio.codigoPostal LIKE %:codigoPostal% OR domicilio.localidad LIKE %:localidad% OR domicilio.numeroDpto LIKE %:numeroDpto% OR domiclio.pisoDpto  LIKE %:pisoDpto% OR domicilio.fechaAlta LIKE %:fechaAlta% OR domicilio.fechaModificacion LIKE %:fechaModificacion% OR domicilio.fechaBaja %:fechaBaja%",
            countQuery = "SELECT count(*) FROM domicilio",
            nativeQuery = true)
    Page<Domicilio> searchNativo(@Param("calle") String calle, @Param("numero")Number numero,@Param("codigoPostal")Number codigoPostal, @Param("localidad")String localidad, @Param("numeroDpto")Number numeroDpto, @Param("pisoDpto")Number pisoDpto, @Param("fechaAlta") Date fechaAlta, @Param("fechaModificacion") Date fechaModificacion, @Param("fechaBaja") Date fechaBaja, Pageable pageable);

}
