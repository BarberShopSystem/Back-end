package br.com.uniamerica.agendaja.agendaja_api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos", schema = "agendaja")
@NoArgsConstructor
public class Produto extends AbstractEntity{
    
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 10)
    private String nome;

    @Getter @Setter
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Getter @Setter
    @JoinColumn(name = "id_tipo", nullable = false)
    @ManyToOne
    private Tipo tipo;

    public Produto(String nome, BigDecimal preco, Tipo tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }
}
