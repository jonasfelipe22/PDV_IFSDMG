package com.posdesenvolvimentoweb.springbootcommysql.repository;

import com.posdesenvolvimentoweb.springbootcommysql.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeProdutoContains(String nomeProduto);
    List<Produto> findByPrecoProdutoGreaterThan(double preco);
}
