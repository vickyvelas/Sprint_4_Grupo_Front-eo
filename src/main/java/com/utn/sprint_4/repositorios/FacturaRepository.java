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

    @Query(value = "Select * FROM Factura WHERE Factura.mp_Payment_Type LIKE %:paymenttype% OR Factura.mp_Preference_Id LIKE %:prefereceid% OR Factura.mp_Payment_Id LIKE %:paymentid% OR Factura.total_Venta LIKE %:totalventa% OR Factura.forma_Pago LIKE %:formapago% OR Factura.mp_Merchant_Order_Id LIKE %:merchantorder% ",
            nativeQuery = true
    )
    List<Factura> searchNativo(@Param("paymenttype") String paymenttype, @Param("preferenceid") String preferenceid, @Param("paymentid") Long paymentid, @Param("totalventa") BigDecimal totalventa, @Param("formapago") FormaPago formapago, @Param("merchantorder") Long merchantorder );

    @Query(value = "Select * FROM Factura WHERE Factura.mp_Payment_Type LIKE %:filtro% OR Factura.mp_Preference_Id LIKE %:filtro% OR Factura.mp_Payment_Id LIKE %:filtro% OR Factura.total_Venta LIKE %:filtro% OR Factura.forma_Pago LIKE %:filtro% OR Factura.mp_Merchant_Order_Id LIKE %:filtro%   ",
            countQuery = "SELECT count(*) FROM Factura",
            nativeQuery = true
    )
    Page<Factura> searchNativo(@Param("paymenttype") String paymenttype, @Param("preferenceid") String preferenceid, @Param("paymentid") Long paymentid, @Param("totalventa") BigDecimal totalventa, @Param("formapago") FormaPago formapago, @Param("merchantorder") Long merchantorder, Pageable pageable);

}
