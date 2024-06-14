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

import br.com.uniamerica.agendaja.agendaja_api.entity.Agendamento;
import br.com.uniamerica.agendaja.agendaja_api.repository.AgendamentoRepository;
import br.com.uniamerica.agendaja.agendaja_api.service.AgendamentoService;

@Controller
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Agendamento agendamento) {
        this.agendamentoRepository.save(agendamento);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.agendamentoRepository.findByAgendamentosAtivos());
    }

    @PutMapping("/atualizarGeral/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Agendamento agendamento) {
        try {
            this.agendamentoService.atualizarGeral(id, agendamento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable final Long id) {
        try {
            this.agendamentoService.deletarGeral(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}