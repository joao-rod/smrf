package br.edu.ifnmg.smrf.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Pessoa extends BaseEntity {

    @Column(length = 100)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column
    private String rg;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, targetEntity = Endereco.class)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, targetEntity = Telefone.class)
    private List<Telefone> telefones;

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }

}
