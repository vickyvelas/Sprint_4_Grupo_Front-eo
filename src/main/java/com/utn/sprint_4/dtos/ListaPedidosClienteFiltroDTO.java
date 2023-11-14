package com.utn.sprint_4.dtos;

import lombok.Data;

@Data
public class ListaPedidosClienteFiltroDTO {
    private String legajo;

    public ListaPedidosClienteFiltroDTO(String legajo) {
        this.legajo = legajo;
    }

    public ListaPedidosClienteFiltroDTO() {
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
}
