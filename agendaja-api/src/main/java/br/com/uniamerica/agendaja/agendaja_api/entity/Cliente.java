package br.com.uniamerica.agendaja.agendaja_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_clientes", schema = "agendaja")
@NoArgsConstructor
public class Cliente extends AbstractEntity {
    
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 9, unique = true)
    private String telefone;

    public Cliente(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }
}
