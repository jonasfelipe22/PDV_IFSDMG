package com.posdesenvolvimentoweb.springbootcommysql.controller.dto;

import com.posdesenvolvimentoweb.springbootcommysql.model.Vendedor;

public class VendedorRs {

    private Long idVendedor;
    private String nomeVendedor;

    public static VendedorRs converter(Vendedor vendedor) {
        var vendedorRs = new VendedorRs();
        vendedorRs.setIdVendedor(vendedor.getIdVendedor());
        vendedorRs.setNomeVendedor(vendedor.getNomeVendedor());
        return vendedorRs;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
