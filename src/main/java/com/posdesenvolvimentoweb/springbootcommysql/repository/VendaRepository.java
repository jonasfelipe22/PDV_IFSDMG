package com.posdesenvolvimentoweb.springbootcommysql.repository;

import com.posdesenvolvimentoweb.springbootcommysql.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByQuantidadeGreaterThan(int quantidade);
}
