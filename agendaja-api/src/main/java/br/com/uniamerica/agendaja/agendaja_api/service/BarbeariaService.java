package br.com.uniamerica.agendaja.agendaja_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniamerica.agendaja.agendaja_api.entity.Barbearia;
import br.com.uniamerica.agendaja.agendaja_api.repository.BarbeariaRepository;
import jakarta.transaction.Transactional;

@Service
public class BarbeariaService {

    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Transactional
    public Barbearia save(Barbearia barbearia) {
        return this.barbeariaRepository.save(barbearia);
    }

    public List<Barbearia> findAll() {
        return this.barbeariaRepository.findByBarbeariasAtivas();
    }

    public Barbearia findById(Long id) {
        return this.barbeariaRepository.findById(id).orElse(new Barbearia());
    }

    @Transactional
    public void atualizarGeral(final Long id, final Barbearia barbearia) {
        if (id.equals(barbearia.getId()) && !this.barbeariaRepository.findById(id).isEmpty()) {
            this.barbeariaRepository.save(barbearia);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id) {
        if (!this.barbeariaRepository.findById(id).isEmpty()) {
            this.barbeariaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}
