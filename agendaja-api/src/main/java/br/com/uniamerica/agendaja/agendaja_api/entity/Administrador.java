package br.com.uniamerica.agendaja.agendaja_api.entity;

import java.time.LocalDateTime;
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
@Table(name = "tb_administradores", schema = "agendaja")
@NoArgsConstructor
public class Administrador extends AbstractEntity{
    

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;

    @Getter @Setter
    @Column(name = "email", unique = true, length = 40, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "senha", nullable = false, unique = true, length = 20)
    private String senha;

    @Getter @Setter
    @Column(name = "telefone", nullable = true, length = 9, unique = true)
    private String telefone;

    @Getter @Setter
    @Column(name = "endereco", nullable = false, unique = true, length = 60)
    private String endereco;

    @Getter @Setter
    @Column(name = "dataNascimento", nullable = false)
    private LocalDateTime dataNascimento;

    @Getter @Setter
    @JoinColumn(name = "id_barbearias")
    @OneToMany
    private List<Barbearia> barbearias; 

    public Administrador(String nome, String email, String senha,String telefone, String endereco, LocalDateTime dataNascimento, List<Barbearia> barbearias){
        this.nome = nome;
        this.email = email;
        this. telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.barbearias = barbearias;
    }
}
