package br.com.uniamerica.agendaja.agendaja_api.service;

import br.com.uniamerica.agendaja.agendaja_api.entity.Horario;
import br.com.uniamerica.agendaja.agendaja_api.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    public Optional<Horario> findById(Long id) {
        return horarioRepository.findById(id);
    }

    public Horario save(Horario horario) {
        return horarioRepository.save(horario);
    }

    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }
}