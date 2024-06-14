package br.com.uniamerica.agendaja.agendaja_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.uniamerica.agendaja.agendaja_api.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT cliente FROM Cliente cliente WHERE cliente.ativo = true")
    public List<Cliente> findByClientesAtivos();
}
