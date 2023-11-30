package com.posdesenvolvimentoweb.springbootcommysql.controller;

import com.posdesenvolvimentoweb.springbootcommysql.controller.dto.VendaRs;
import com.posdesenvolvimentoweb.springbootcommysql.controller.dto.VendaRq;
import com.posdesenvolvimentoweb.springbootcommysql.model.Venda;
import com.posdesenvolvimentoweb.springbootcommysql.repository.VendaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/venda")
public class VendaController {

    private final VendaRepository vendaRepository;

    public VendaController(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    @GetMapping("/")
    public List<VendaRs> findAll() {
        var vendas = vendaRepository.findAll();
        return vendas
                .stream()
                .map(VendaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VendaRs findById(@PathVariable("id") Long id) {
        var venda = vendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        return VendaRs.converter(venda);
    }

    @PostMapping("/")
	public void saveVenda(@RequestBody VendaRq vendaRq) {
		Venda venda = new Venda();
		venda.setIdProduto(vendaRq.getIdProduto());
		venda.setQuantidade(vendaRq.getQuantidade());
		venda.setIdVendedor(vendaRq.getIdVendedor());
		vendaRepository.save(venda);
	}

    @PutMapping("/{id}")
    public void updateVenda(@PathVariable("id") Long id, @RequestBody VendaRq venda) {
        var v = vendaRepository.findById(id);

        if (v.isPresent()) {
            var vendaSave = v.get();
            vendaSave.setIdProduto(venda.getIdProduto());
            vendaSave.setQuantidade(venda.getQuantidade());
            vendaSave.setIdVendedor(venda.getIdVendedor());
            vendaRepository.save(vendaSave);
        } else {
            throw new RuntimeException("Venda não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteVenda(@PathVariable("id") Long id) {
        vendaRepository.deleteById(id);
    }

    @GetMapping("/filter")
    public List<VendaRs> findVendaByQuantidade(@RequestParam("quantidade") int quantidade) {
        return this.vendaRepository.findByQuantidadeGreaterThan(quantidade)
                .stream()
                .map(VendaRs::converter)
                .collect(Collectors.toList());
    }
}
