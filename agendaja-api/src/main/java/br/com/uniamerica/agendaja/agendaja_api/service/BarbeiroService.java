package br.com.uniamerica.agendaja.agendaja_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.uniamerica.agendaja.agendaja_api.entity.Barbeiro;
import br.com.uniamerica.agendaja.agendaja_api.repository.BarbeiroRepository;
import jakarta.transaction.Transactional;

@Service
public class BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Transactional
    public Barbeiro save(Barbeiro barbeiro) {
        return this.barbeiroRepository.save(barbeiro);
    }

    public List<Barbeiro> findAll() {
        return this.barbeiroRepository.findByBarbeirosAtivos();
    }

    public Barbeiro findById(Long id) {
        return this.barbeiroRepository.findById(id).orElse(new Barbeiro());
    }

    @Transactional
    public void atualizarGeral(final Long id, final Barbeiro barbeiro) {
        if (id.equals(barbeiro.getId()) && !this.barbeiroRepository.findById(id).isEmpty()) {
            this.barbeiroRepository.save(barbeiro);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id) {
        if (!this.barbeiroRepository.findById(id).isEmpty()) {
            this.barbeiroRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}
