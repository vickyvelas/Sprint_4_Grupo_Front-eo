package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.DetalleFactura;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService{
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository) {
        super(baseRepository);
        this.detalleFacturaRepository = detalleFacturaRepository;
    }
    @Override
    public List<DetalleFactura> search(int filtro) throws Exception {
        try{
            //   List<DetalleFactura> detalleFactura= detalleFacturaRepository.findBySubTotal(filtro);
            //   List<DetalleFactura> detalleFactura = detalleFacturaRepository.search(filtro);
            List<DetalleFactura> detalleFactura = detalleFacturaRepository.searchNativo(filtro);
            return detalleFactura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<DetalleFactura> search(int filtro, Pageable pageable) throws Exception {
        try{
            //   Page<DetalleFactura> detallesFactura= facturaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //   Page<DetalleFactura> detallesFactura = facturaRepository.search(filtro, pageable);
            Page<DetalleFactura> detallesFactura = detalleFacturaRepository.searchNativo(filtro, pageable);
            return detallesFactura;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
