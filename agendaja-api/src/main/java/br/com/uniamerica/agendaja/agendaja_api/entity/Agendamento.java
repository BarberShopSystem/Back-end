package br.com.uniamerica.agendaja.agendaja_api.entity;


import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_agendamentos", schema = "agendaja")
@NoArgsConstructor
public class Agendamento extends AbstractEntity{
    
    @Getter @Setter
    @JoinColumn(name = "id_barbearia")
    @ManyToOne
    private Barbearia barbearia; 
    
    @Getter @Setter
    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente; 

    @Getter @Setter
    @ManyToMany
    @JoinTable(
        name = "agendamento_produto",
        schema = "agendaja",
        joinColumns = @JoinColumn(name = "agendamento_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
        name = "agendamento_servico",
        schema = "agendaja",
        joinColumns = @JoinColumn(name = "agendamento_id"),
        inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private List<Servico> servicos;

    @Getter @Setter
    @JoinColumn(name = "id_barbeiros")
    @ManyToOne
    private Barbeiro barbeiro; 

    @Getter @Setter
    @JoinColumn(name = "id_horarioData")
    @OneToOne
    private Horario horarioData; 

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "statusAgendamento", nullable = false)
    private StatusAgendamento statusAgendamento;

    @Getter @Setter
    @Column(name = "custoAgendamento", nullable = false)
    private BigDecimal custoAgendamento;

    @Getter @Setter
    @Column(name = "faturamentoServico", nullable = false)
    private BigDecimal faturamentoServico;

    public Agendamento(Barbearia barbearia, Cliente cliente,List<Produto> produtos, List<Servico> servicos, Barbeiro barbeiro, Horario horarioData,
    StatusAgendamento statusAgendamento, BigDecimal custoAgendamento, BigDecimal faturamentoServico){
        this.barbearia = barbearia;
        this.cliente = cliente;
        this.produtos = produtos;
        this.servicos = servicos;
        this.horarioData = horarioData;
        this.statusAgendamento = statusAgendamento;
        this.custoAgendamento  = custoAgendamento;
        this.faturamentoServico = faturamentoServico;
    }

}
