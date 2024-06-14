package br.com.uniamerica.agendaja.agendaja_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.uniamerica.agendaja.agendaja_api.entity.Barbeiro;
import br.com.uniamerica.agendaja.agendaja_api.repository.BarbeiroRepository;
import br.com.uniamerica.agendaja.agendaja_api.service.BarbeiroService;

@Controller
@RequestMapping("/api/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private BarbeiroService barbeiroService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Barbeiro barbeiro) {
        this.barbeiroRepository.save(barbeiro);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.barbeiroRepository.findByBarbeirosAtivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbeiro> findById(
            @PathVariable final Long id
    ) {
        return ResponseEntity.ok().body(this.barbeiroService.findById(id));
    }

    @PutMapping("/atualizarGeral/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Barbeiro barbeiro) {
        try {
            this.barbeiroService.atualizarGeral(id, barbeiro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable final Long id) {
        try {
            this.barbeiroService.deletarGeral(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}
