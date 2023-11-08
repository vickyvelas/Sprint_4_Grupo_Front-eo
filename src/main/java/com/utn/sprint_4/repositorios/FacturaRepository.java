package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.Factura;
import com.utn.sprint_4.enumeraciones.FormaPago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long>{

    @Query(value = "Select * FROM Factura WHERE Factura.paymenttype LIKE %:paymenttype% OR Factura.preferenceid LIKE %:preferenceid% OR Factura.paymentid LIKE %:paymentid% OR Factura.totalventa LIKE %:totalventa% OR Factura.formaPago LIKE %:formapago% OR Factura.merchantorder LIKE %:merchantorder% ",
            nativeQuery = true
    )
    List<Factura> searchNativo(@Param("paymenttype") String paymenttype, @Param("preferenceid") String preferenceid, @Param("paymentid") Long paymentid, @Param("totalventa") BigDecimal totalventa, @Param("formapago") FormaPago formapago, @Param("merchantorder") Long merchantorder );

    @Query(value = "Select * FROM Factura WHERE Factura.paymenttype LIKE %:paymenttype% OR Factura.preferenceid LIKE %:preferenceid% OR Factura.paymentid LIKE %:paymentid% OR Factura.totalventa LIKE %:totalventa% OR Factura.formaPago LIKE %:formapago% OR Factura.merchantorder LIKE %:merchantorder% ",
            countQuery = "SELECT count(*) FROM Factura",
            nativeQuery = true
    )
    Page<Factura> searchNativo(@Param("paymenttype") String paymenttype, @Param("preferenceid") String preferenceid, @Param("paymentid") Long paymentid, @Param("totalventa") BigDecimal totalventa, @Param("formapago") FormaPago formapago, @Param("merchantorder") Long merchantorder, Pageable pageable);

}
