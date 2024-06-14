package br.com.uniamerica.agendaja.agendaja_api.controller;

import br.com.uniamerica.agendaja.agendaja_api.entity.Servico;
import br.com.uniamerica.agendaja.agendaja_api.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.findById(id);
        return servico.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id, @RequestBody Servico servicoDetails) {
        Optional<Servico> servicoOptional = servicoService.findById(id);
        if (!servicoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Servico servico = servicoOptional.get();
        servico.setNome(servicoDetails.getNome());
        servico.setPreco(servicoDetails.getPreco());
        servico.setTipo(servicoDetails.getTipo());

        Servico updatedServico = servicoService.save(servico);
        return ResponseEntity.ok(updatedServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.findById(id);
        if (!servico.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}