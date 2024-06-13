package br.com.uniamerica.agendaja.agendaja_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_dashboards", schema = "agendaja")
@NoArgsConstructor
public class Dashboard extends AbstractEntity{
    
    @Getter @Setter
    @JoinColumn(name = "id_administrador", nullable = false)
    @OneToOne
    private Administrador administrador;

    public Dashboard(Administrador administrador){
        this.administrador = administrador;
    }
}
