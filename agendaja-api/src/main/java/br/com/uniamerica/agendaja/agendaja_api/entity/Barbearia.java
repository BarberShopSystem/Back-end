package br.com.uniamerica.agendaja.agendaja_api.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_barbearias", schema = "agendaja")
@NoArgsConstructor
public class Barbearia extends AbstractEntity {
 
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Getter @Setter
    @Column(name = "endereco", nullable = false, length = 60, unique = true)
    private String endereco;

    @Getter @Setter
    @JoinColumn(name = "id_barbeiros")
    @OneToMany
    private List<Barbeiro> barbeiros; 

    @Getter @Setter
    @JoinColumn(name = "id_servicos")
    @OneToMany
    private List<Servico> servicos;

    @Getter @Setter
    @JoinColumn(name = "id_produtos")
    @OneToMany
    private List<Produto> produtos;

    @Getter @Setter
    @Column(name = "faturamento_diario")
    private List<String> faturamentoDiario;


    @Getter @Setter
    @Column(name = "faturamento_mensal")
    private List<String> faturamentoMensal;

    @Getter @Setter
    @JoinColumn(name = "id_agendamento")
    @OneToMany
    private List<Agendamento> historico;

    public Barbearia(String nome, String endereco, List<Barbeiro> barbeiros, List<Servico> servicos, List<Produto> produtos, List<String> faturamentoDiario, List<String> faturamentoMensal, List<Agendamento> historico) {
        this.nome = nome;
        this.endereco = endereco;
        this.barbeiros = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.faturamentoDiario = new ArrayList<>();
        this.faturamentoMensal = new ArrayList<>();
        this.historico = new ArrayList<>();
    }
}