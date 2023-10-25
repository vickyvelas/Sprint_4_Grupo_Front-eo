package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Pedido;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService {


    @Autowired
    private PedidoRepository pedidoRepository;


    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {

        super(baseRepository);
    }

    @Override
    public List<Pedido> search(String filtro) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.searchNativoFpago(filtro);
            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Pedido> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Pedido> pedidos = pedidoRepository.searchNativoFpagoPageabe(filtro, pageable);
            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
