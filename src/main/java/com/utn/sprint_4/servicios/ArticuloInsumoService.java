package com.utn.sprint_4.servicios;

import com.utn.sprint_4.dtos.ControlStockDTO;
import com.utn.sprint_4.entidades.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

    List<ControlStockDTO> controlStockInsuficiente() throws Exception;

    List<ControlStockDTO> controlStockBajo() throws Exception;
    List<ArticuloInsumo> search(String denominacion, Number min, Number max, Number stockMenor, Number minStock, Number maxStock) throws Exception;

    Page<ArticuloInsumo> search(String denominacion, Number min, Number max, Number stockMenor, Number minStock, Number maxStock, Pageable pageable) throws Exception;
}
