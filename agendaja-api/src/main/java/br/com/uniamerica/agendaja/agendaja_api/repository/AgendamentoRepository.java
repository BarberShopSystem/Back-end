package br.com.uniamerica.agendaja.agendaja_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.uniamerica.agendaja.agendaja_api.entity.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
    @Query("SELECT agendamento FROM Agendamento agendamento WHERE agendamento.ativo = true")
    public List<Agendamento> findByAgendamentosAtivos();
}