package br.com.uniamerica.agendaja.agendaja_api.controller;

import br.com.uniamerica.agendaja.agendaja_api.entity.Produto;
import br.com.uniamerica.agendaja.agendaja_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Optional<Produto> produtoOptional = produtoService.findById(id);
        if (!produtoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Produto produto = produtoOptional.get();
        produto.setNome(produtoDetails.getNome());
        produto.setPreco(produtoDetails.getPreco());
        produto.setTipo(produtoDetails.getTipo());

        Produto updatedProduto = produtoService.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        if (!produto.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}