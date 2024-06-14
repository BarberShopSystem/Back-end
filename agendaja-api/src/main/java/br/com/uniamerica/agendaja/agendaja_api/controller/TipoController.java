package br.com.uniamerica.agendaja.agendaja_api.controller;

import br.com.uniamerica.agendaja.agendaja_api.entity.Tipo;
import br.com.uniamerica.agendaja.agendaja_api.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<Tipo> getAllTipos() {
        return tipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoById(@PathVariable Long id) {
        Optional<Tipo> tipo = tipoService.findById(id);
        return tipo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tipo createTipo(@RequestBody Tipo tipo) {
        return tipoService.save(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> updateTipo(@PathVariable Long id, @RequestBody Tipo tipoDetails) {
        Optional<Tipo> tipoOptional = tipoService.findById(id);
        if (!tipoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Tipo tipo = tipoOptional.get();
        tipo.setNome(tipoDetails.getNome());

        Tipo updatedTipo = tipoService.save(tipo);
        return ResponseEntity.ok(updatedTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        Optional<Tipo> tipo = tipoService.findById(id);
        if (!tipo.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}