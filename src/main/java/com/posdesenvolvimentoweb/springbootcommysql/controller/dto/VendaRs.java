package com.posdesenvolvimentoweb.springbootcommysql.controller.dto;

import com.posdesenvolvimentoweb.springbootcommysql.model.Venda;

public class VendaRs {

    private Long idVenda;
    private Long idProduto;
    private Integer quantidade;
    private Long idVendedor;

    public static VendaRs converter(Venda venda) {
        var vendaRs = new VendaRs();
        vendaRs.setIdVenda(venda.getIdVenda());
        vendaRs.setIdProduto(venda.getIdProduto());
        vendaRs.setQuantidade(venda.getQuantidade());
        vendaRs.setIdVendedor(venda.getIdVendedor());
        return vendaRs;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }
}
