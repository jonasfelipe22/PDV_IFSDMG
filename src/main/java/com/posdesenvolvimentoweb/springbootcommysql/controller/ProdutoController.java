package com.posdesenvolvimentoweb.springbootcommysql.controller;

import com.posdesenvolvimentoweb.springbootcommysql.controller.dto.ProdutoRs;
import com.posdesenvolvimentoweb.springbootcommysql.controller.dto.ProdutoRq;
import com.posdesenvolvimentoweb.springbootcommysql.model.Produto;
import com.posdesenvolvimentoweb.springbootcommysql.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/")
    public List<ProdutoRs> findAll() {
        final var produtos = produtoRepository.findAll();
        return produtos
                .stream()
                .map(ProdutoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProdutoRs findById(@PathVariable("id") Long id) {
        var produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProdutoRs.converter(produto);
    }

    @PostMapping("/")
	public void saveProduto(@RequestBody ProdutoRq produtoRq) {
		Produto produto = new Produto();
		produto.setNomeProduto(produtoRq.getNomeProduto());
		produto.setPrecoProduto(produtoRq.getPrecoProduto());
		produtoRepository.save(produto);
	}

    @PutMapping("/{id}")
    public void updateProduto(@PathVariable("id") Long id, @RequestBody ProdutoRq produto) {
        var p = produtoRepository.findById(id);

        if (p.isPresent()) {
            var produtoSave = p.get();
            produtoSave.setNomeProduto(produto.getNomeProduto());
            produtoSave.setPrecoProduto(produto.getPrecoProduto());
            produtoRepository.save(produtoSave);
        } else {
            throw new RuntimeException("Produto não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
    }

    @GetMapping("/filter")
    public List<ProdutoRs> findProdutoByNome(@RequestParam("nome") String nome) {
        return this.produtoRepository.findByNomeProdutoContains(nome)
                .stream()
                .map(ProdutoRs::converter)
                .collect(Collectors.toList());
    }
}
