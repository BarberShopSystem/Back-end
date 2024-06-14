package br.com.uniamerica.agendaja.agendaja_api.service;

import br.com.uniamerica.agendaja.agendaja_api.entity.Tipo;
import br.com.uniamerica.agendaja.agendaja_api.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

    public Optional<Tipo> findById(Long id) {
        return tipoRepository.findById(id);
    }

    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public void deleteById(Long id) {
        tipoRepository.deleteById(id);
    }
}