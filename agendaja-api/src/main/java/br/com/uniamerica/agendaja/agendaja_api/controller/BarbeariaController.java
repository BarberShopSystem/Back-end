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

import br.com.uniamerica.agendaja.agendaja_api.entity.Barbearia;
import br.com.uniamerica.agendaja.agendaja_api.repository.BarbeariaRepository;
import br.com.uniamerica.agendaja.agendaja_api.service.BarbeariaService;

@Controller
@RequestMapping("/api/barbearias")
public class BarbeariaController {

    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Autowired
    private BarbeariaService barbeariaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Barbearia barbearia) {
        this.barbeariaRepository.save(barbearia);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.barbeariaRepository.findByBarbeariasAtivas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barbearia> findById(
            @PathVariable final Long id
    ) {
        return ResponseEntity.ok().body(this.barbeariaService.findById(id));
    }

    @PutMapping("/atualizarGeral/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Barbearia barbearia) {
        try {
            this.barbeariaService.atualizarGeral(id, barbearia);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable final Long id) {
        try {
            this.barbeariaService.deletarGeral(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}