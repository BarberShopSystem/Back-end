package br.com.uniamerica.agendaja.agendaja_api.repository;

import br.com.uniamerica.agendaja.agendaja_api.entity.Horario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query("SELECT horario FROM Horario horario WHERE horario.statusHorario = 'DISPONIVEL'")
    public List<Horario> findAllDisponiveis();
}