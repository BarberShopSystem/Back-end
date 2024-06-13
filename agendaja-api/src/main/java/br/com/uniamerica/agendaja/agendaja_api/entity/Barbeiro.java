package br.com.uniamerica.agendaja.agendaja_api.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_barbeiros", schema = "agendaja")
@NoArgsConstructor
public class Barbeiro extends AbstractEntity{
    
    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
        name = "horarioData",
        schema = "agendaja",
        joinColumns = @JoinColumn(name = "id_barbeiro"),
        inverseJoinColumns = @JoinColumn(name = "id_horario")
    )
    private List<Horario> horarioData;

    @Getter @Setter
    @Column(name = "comicao", nullable = false)
    private Long comicao;

    @Getter @Setter
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Getter @Setter
    @Column(name = "idade", nullable = false)
    private Number idade;

    @Getter @Setter
    @Column(name = "faturamento_diario")
    private List<String> faturamentoDiario;

    @Getter @Setter
    @Column(name = "faturamento_mensal")
    private List<String> faturamentoMensal;

    @Getter @Setter
    @JoinColumn(name = "id_historico")
    @OneToMany
    private List<Agendamento> historico;


     public Barbeiro(String nome, List<Horario> horarioData, Long comicao, Number idade, String email, List<String> faturamentoDiario, List<String> faturamentoMensal, List<Agendamento> historico) {
        this.nome = nome;
        this.horarioData = horarioData;
        this.idade = idade;
        this.comicao = comicao;
        this.email = email;
        this.faturamentoDiario = new ArrayList<>();
        this.faturamentoMensal = new ArrayList<>();
        this.historico = new ArrayList<>();
    }


}