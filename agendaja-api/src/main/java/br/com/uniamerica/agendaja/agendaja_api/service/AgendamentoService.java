package br.com.uniamerica.agendaja.agendaja_api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.uniamerica.agendaja.agendaja_api.entity.Agendamento;
import br.com.uniamerica.agendaja.agendaja_api.repository.AgendamentoRepository;
import jakarta.transaction.Transactional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Transactional
    public Agendamento save(Agendamento agendamento) {
        return this.agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> findAll() {
        return this.agendamentoRepository.findByAgendamentosAtivos();
    }

    @Transactional
    public void atualizarGeral(final Long id, final Agendamento agendamento) {
        if (id.equals(agendamento.getId()) && this.agendamentoRepository.findById(id).isEmpty()) {
            this.agendamentoRepository.save(agendamento);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id) {
        if (this.agendamentoRepository.findById(id).isEmpty()) {
            this.agendamentoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}