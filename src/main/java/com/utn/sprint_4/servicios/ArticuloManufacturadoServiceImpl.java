package com.utn.sprint_4.servicios;

import com.utn.sprint_4.dtos.BusquedaProductosDTO;
import com.utn.sprint_4.dtos.RankingProductosDTO;
import com.utn.sprint_4.dtos.RankingProductosFiltroDTO;
import com.utn.sprint_4.entidades.ArticuloManufacturado;
import com.utn.sprint_4.entidades.DetalleFactura;
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
    public List<RankingProductosDTO> rankingProductos(RankingProductosFiltroDTO rankingProductosFiltroDTO) throws Exception {
        try {
            List<ArticuloManufacturado> articulosMasVendidos = articuloManufacturadoRepository.rankingProductos(rankingProductosFiltroDTO.getFechaInicio(), rankingProductosFiltroDTO.getFechaFin());
            List<RankingProductosDTO> rankingDTO = new ArrayList<>();

            for (ArticuloManufacturado articulos : articulosMasVendidos) {
                RankingProductosDTO dtoAux = new RankingProductosDTO();
                dtoAux.setDenominacion(articulos.getDenominacion());
                dtoAux.setDescripcion(articulos.getDescripcion());

                for (DetalleFactura detalles : articulos.getDetalleFacturas()) {
                    dtoAux.setCantidad(detalles.getCantidad());
                }

                // Lo agrega a la lista solo si la cantidad es mayor o igual a 5
                if (dtoAux.getCantidad() >= 5) {
                    rankingDTO.add(dtoAux);
                }
            }
            return rankingDTO;
        } catch (Exception e) {
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
