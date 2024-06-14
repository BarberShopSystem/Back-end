package br.com.uniamerica.agendaja.agendaja_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniamerica.agendaja.agendaja_api.entity.Cliente;
import br.com.uniamerica.agendaja.agendaja_api.repository.ClienteRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findByClientesAtivos();
    }

    @Transactional
    public void atualizarGeral(final Long id, final Cliente cliente) {
        if (id.equals(cliente.getId()) && !this.clienteRepository.findById(id).isEmpty()) {
            this.clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id) {
        if (!this.clienteRepository.findById(id).isEmpty()) {
            this.clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }
}