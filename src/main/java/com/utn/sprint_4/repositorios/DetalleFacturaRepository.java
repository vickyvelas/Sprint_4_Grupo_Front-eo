package com.utn.sprint_4.repositorios;

import com.utn.sprint_4.entidades.DetalleFactura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura, Long>{
    List<DetalleFactura> findBySubtotal(int subtotal);
    Page<DetalleFactura> findBySubtotal(int subtotal, Pageable pageable);

    @Query(value = "Select fDet FROM DetalleFactura fDet WHERE fDet.cantidad=:filtro")
    List<DetalleFactura> search(@Param("filtro") int filtro);

    @Query(value = "Select fDet FROM DetalleFactura fDet WHERE fDet.cantidad=:filtro")
    Page<DetalleFactura> search(@Param("filtro") int filtro, Pageable pageable);

    @Query(value = "Select * FROM DetalleFactura WHERE fDet.cantidad LIKE %:filtro% ",
            nativeQuery = true
    )

    List<DetalleFactura> searchNativo(@Param("filtro") int filtro);

    @Query(value = "Select fDet FROM DetalleFactura fDet WHERE fDet.cantidad LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM DetalleFactura",
            nativeQuery = true
    )
    Page<DetalleFactura> searchNativo(@Param("filtro")int filtro, Pageable pageable);

}