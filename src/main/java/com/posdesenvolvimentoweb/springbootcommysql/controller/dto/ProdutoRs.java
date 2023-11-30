package com.posdesenvolvimentoweb.springbootcommysql.controller.dto;

import com.posdesenvolvimentoweb.springbootcommysql.model.Produto;

public class ProdutoRs {

    private Long idProduto;
    private String nomeProduto;
    private Double precoProduto;

    public static ProdutoRs converter(Produto produto) {
        var produtoRs = new ProdutoRs();
        produtoRs.setIdProduto(produto.getIdProduto());
        produtoRs.setNomeProduto(produto.getNomeProduto());
        produtoRs.setPrecoProduto(produto.getPrecoProduto());
        return produtoRs;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }
}
