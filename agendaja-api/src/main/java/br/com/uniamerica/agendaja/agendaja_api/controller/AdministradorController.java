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

import br.com.uniamerica.agendaja.agendaja_api.entity.Administrador;
import br.com.uniamerica.agendaja.agendaja_api.repository.AdministradorRepository;
import br.com.uniamerica.agendaja.agendaja_api.service.AdministradorService;

@Controller
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    public AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Administrador administrador) {
        this.administradorRepository.save(administrador);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.administradorRepository.findByAdministradoresAtivos());
    }

    @PutMapping("/atualizarGeral/{id}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Administrador administrador) {
        try {
            this.administradorService.atualizarGeral(id, administrador);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id) {
        try {
            this.administradorService.deletarGeral(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }

}
