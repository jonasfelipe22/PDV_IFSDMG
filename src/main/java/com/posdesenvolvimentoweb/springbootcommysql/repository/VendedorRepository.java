package com.posdesenvolvimentoweb.springbootcommysql.repository;

import com.posdesenvolvimentoweb.springbootcommysql.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    List<Vendedor> findByNomeVendedorContains(String nomeVendedor);
}
