package br.com.uniamerica.agendaja.agendaja_api.controller;

import br.com.uniamerica.agendaja.agendaja_api.entity.Horario;
import br.com.uniamerica.agendaja.agendaja_api.repository.HorarioRepository;
import br.com.uniamerica.agendaja.agendaja_api.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @Autowired
    private HorarioRepository horarioRepository;

    @GetMapping
    public List<Horario> getAllHorarios() {
        return horarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> getHorarioById(@PathVariable Long id) {
        Optional<Horario> horario = horarioService.findById(id);
        return horario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/horariosDisponiveis")
    public ResponseEntity<?> findAllHorariosDiponiveis() {
        return ResponseEntity.ok().body(this.horarioRepository.findAllDisponiveis());
    }

    @PostMapping
    public Horario createHorario(@RequestBody Horario horario) {
        return horarioService.save(horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> updateHorario(@PathVariable Long id, @RequestBody Horario horarioDetails) {
        Optional<Horario> horarioOptional = horarioService.findById(id);
        if (!horarioOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Horario horario = horarioOptional.get();
        horario.setHorario(horarioDetails.getHorario());
        horario.setStatusHorario(horarioDetails.getStatusHorario());

        Horario updatedHorario = horarioService.save(horario);
        return ResponseEntity.ok(updatedHorario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable Long id) {
        Optional<Horario> horario = horarioService.findById(id);
        if (!horario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        horarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}