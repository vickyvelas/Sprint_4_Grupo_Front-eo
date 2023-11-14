package com.utn.sprint_4.servicios;

import com.utn.sprint_4.dtos.ControlStockDTO;
import com.utn.sprint_4.entidades.ArticuloInsumo;
import com.utn.sprint_4.repositorios.ArticuloInsumoRepository;
import com.utn.sprint_4.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService{
    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Override
    public List<ControlStockDTO> controlStockInsuficiente() throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.controlStockInsuficiente();
            List<ControlStockDTO> stockDTO = new ArrayList<>();

            for (ArticuloInsumo articulos : articuloInsumos) {
                // Verifica si el stock actual es menor que el stock mínimo
                if (articulos.getStockActual() < articulos.getStockMinimo()) {
                    ControlStockDTO auxDTO = new ControlStockDTO();
                    auxDTO.setNombre(articulos.getDenominacion());
                    auxDTO.setDenominacion(articulos.getUnidadMedida().getDenominacion());
                    auxDTO.setAbreviatura(articulos.getUnidadMedida().getAbreviatura());
                    auxDTO.setStockMinimo(articulos.getStockMinimo());
                    auxDTO.setStockActual(articulos.getStockActual());
                    auxDTO.setDiferenciaStock(articulos.getStockActual() - articulos.getStockMinimo());

                    stockDTO.add(auxDTO);
                }
            }
            return stockDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<ControlStockDTO> controlStockBajo() throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.controlStockInsuficiente();
            List<ControlStockDTO> stockDTO = new ArrayList<>();

            for (ArticuloInsumo articulos : articuloInsumos) {
                double porcentajeUmbral = 20.0;

                double diferenciaPorcentaje = ((double) articulos.getStockActual() / articulos.getStockMinimo() - 1) * 100;

                // Verifica si la diferencia porcentual es menor o igual al 20%
                // y si el stock actual no está por debajo del stock mínimo
                if (diferenciaPorcentaje <= porcentajeUmbral && articulos.getStockActual() >= articulos.getStockMinimo()) {
                    ControlStockDTO auxDTO = new ControlStockDTO();
                    auxDTO.setNombre(articulos.getDenominacion());
                    auxDTO.setDenominacion(articulos.getUnidadMedida().getDenominacion());
                    auxDTO.setAbreviatura(articulos.getUnidadMedida().getAbreviatura());
                    auxDTO.setStockMinimo(articulos.getStockMinimo());
                    auxDTO.setStockActual(articulos.getStockActual());
                    auxDTO.setDiferenciaStock(articulos.getStockActual() - articulos.getStockMinimo());

                    stockDTO.add(auxDTO);
                }
            }
            return stockDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    @Override
    public List<ArticuloInsumo> search(String denominacion, Number min, Number max, Number stockMenor, Number minStock, Number maxStock) throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.searchNativo(denominacion,min,max,stockMenor,minStock,maxStock);
            return articuloInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloInsumo> search(String denominacion, Number min, Number max, Number stockMenor, Number minStock, Number maxStock, Pageable pageable) throws Exception {
        try {
            Page<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.searchNativo(denominacion,min,max,stockMenor,minStock,maxStock, pageable);
            return articuloInsumos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
