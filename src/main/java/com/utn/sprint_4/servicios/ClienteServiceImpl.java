package com.utn.sprint_4.servicios;

import com.utn.sprint_4.entidades.Cliente;
import com.utn.sprint_4.repositorios.BaseRepository;
import com.utn.sprint_4.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> search(String nombre, String apellido, String email, String telefono) throws Exception {
        try{
            //   List<Cliente> clientes= clienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //   List<Cliente> clientes = clienteRepository.search(filtro);
            List<Cliente> clientes = clienteRepository.searchNativo(nombre, apellido, email, telefono);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String nombre, String apellido, String email, String telefono, Pageable pageable) throws Exception {
        try{
            //   Page<Cliente> clientes= clienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //   Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            Page<Cliente> clientes = clienteRepository.searchNativo(nombre, apellido, email, telefono, pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /*@Override
    public List<Cliente> searchPedidos(Long id) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.searchPedidos(id);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> searchPedidos(Long id, Pageable pageable) throws Exception {
        try{
            Page<Cliente> clientes = clienteRepository.searchPedidos(id, pageable);
            return clientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/
}
