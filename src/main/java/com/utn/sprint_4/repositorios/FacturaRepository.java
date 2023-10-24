package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Factura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long>{

    @Query(value = "Select * FROM Factura WHERE Factura.mp_Payment_Type LIKE %:filtro% OR Factura.mp_Preference_Id LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Factura> searchNativo(@Param("filtro")  String filtro);

    @Query(value = "Select * FROM Factura WHERE Factura.mp_Payment_Type LIKE %:filtro% OR Factura.mp_Preference_Id LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM Factura",
            nativeQuery = true
    )
    Page<Factura> searchNativo(@Param("filtro") String filtro, Pageable pageable);


}