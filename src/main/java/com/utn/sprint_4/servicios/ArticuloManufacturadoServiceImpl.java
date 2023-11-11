package com.utn.sprint_4.servicios;

import com.utn.sprint_4.dtos.BusquedaProductosDTO;
import com.utn.sprint_4.dtos.DTORankingProductos;
import com.utn.sprint_4.entidades.ArticuloManufacturado;
import com.utn.sprint_4.repositorios.ArticuloManufacturadoRepository;
import com.utn.sprint_4.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }


    @Override
    public List<BusquedaProductosDTO> findByDenominacion(String denominacion) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findByDenominacion(denominacion);
            List<BusquedaProductosDTO> productosDTOS  = new ArrayList<>();
            BusquedaProductosDTO auxDto = new BusquedaProductosDTO();
            for (ArticuloManufacturado articuloManufacturado : articuloManufacturados){
                auxDto.setDenominacion(articuloManufacturado.getDenominacion());
                auxDto.setDescripcion(articuloManufacturado.getDescripcion());
                auxDto.setPrecioVenta(articuloManufacturado.getPrecioVenta());
                auxDto.setUrlImagen(articuloManufacturado.getUrlImagen());
                productosDTOS.add(auxDto);
            }
            return productosDTOS;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTORankingProductos> findBy() throws Exception {
        try {
            List<DTORankingProductos> articulosMasVendidos = articuloManufacturadoRepository.findBy();
            return articulosMasVendidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<ArticuloManufacturado> buscarProducto(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchNativo(filtro);
            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> buscarProducto(String filtro, Pageable pageable) throws Exception {
        try {
            Page<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.searchNativo(filtro, pageable);
            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
