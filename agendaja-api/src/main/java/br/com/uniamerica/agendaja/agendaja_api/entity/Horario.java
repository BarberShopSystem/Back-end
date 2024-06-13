package br.com.uniamerica.agendaja.agendaja_api.entity;


import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_horarios", schema = "agendaja")
@NoArgsConstructor
public class Horario extends AbstractEntity{

    @Getter @Setter
    @Column(name = "horario", nullable = false)
    private LocalDateTime horario;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "statusHorario", nullable = false)
    private StatusHorario statusHorario;
    
     public Horario(LocalDateTime horario, StatusHorario statusHorario) {
        this.horario = horario;
        this.statusHorario = statusHorario;
    }
}
