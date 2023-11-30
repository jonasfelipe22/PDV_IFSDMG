package com.posdesenvolvimentoweb.springbootcommysql.controller;

import com.posdesenvolvimentoweb.springbootcommysql.controller.dto.VendedorRs;
import com.posdesenvolvimentoweb.springbootcommysql.controller.dto.VendedorRq;
import com.posdesenvolvimentoweb.springbootcommysql.model.Vendedor;
import com.posdesenvolvimentoweb.springbootcommysql.repository.VendedorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    private final VendedorRepository vendedorRepository;

    public VendedorController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @GetMapping("/")
    public List<VendedorRs> findAll() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return vendedores.stream()
                .map(VendedorRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VendedorRs findById(@PathVariable("id") Long id) {
        Vendedor vendedor = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
        return VendedorRs.converter(vendedor);
    }

    @PostMapping("/")
	public void saveVendedor(@RequestBody VendedorRq vendedorRq) {
		Vendedor vendedor = new Vendedor();
		vendedor.setNomeVendedor(vendedorRq.getNomeVendedor());
		vendedorRepository.save(vendedor);
	}

    @PutMapping("/{id}")
    public void updateVendedor(@PathVariable("id") Long id, @RequestBody VendedorRq vendedorRq) {
        Vendedor vendedor = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));

        vendedor.setNomeVendedor(vendedorRq.getNomeVendedor());
        vendedorRepository.save(vendedor);
    }

    @DeleteMapping("/{id}")
    public void deleteVendedor(@PathVariable("id") Long id) {
        vendedorRepository.deleteById(id);
    }
}
