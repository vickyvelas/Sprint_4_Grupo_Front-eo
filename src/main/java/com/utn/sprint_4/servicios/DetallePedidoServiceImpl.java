package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.DetallePedido;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<DetallePedido> search(int filtro) throws Exception {
        try {
            List<DetallePedido> detallePedidos = detallePedidoRepository.searchNativo(filtro);
            return detallePedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetallePedido> search(int filtro, Pageable pageable) throws Exception {
        try {
            Page<DetallePedido> detallePedidos = detallePedidoRepository.searchNativo(filtro, pageable);
            return detallePedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
