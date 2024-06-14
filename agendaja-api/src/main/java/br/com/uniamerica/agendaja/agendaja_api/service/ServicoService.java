package br.com.uniamerica.agendaja.agendaja_api.service;

import br.com.uniamerica.agendaja.agendaja_api.entity.Servico;
import br.com.uniamerica.agendaja.agendaja_api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> findById(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deleteById(Long id) {
        servicoRepository.deleteById(id);
    }
}
