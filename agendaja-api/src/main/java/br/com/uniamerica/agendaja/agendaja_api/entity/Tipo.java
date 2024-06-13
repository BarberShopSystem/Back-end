package br.com.uniamerica.agendaja.agendaja_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tipos", schema = "agendaja")
@NoArgsConstructor
public class Tipo extends AbstractEntity{
     
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    public Tipo(String nome) {
        this.nome = nome;
    }

}
