package br.edu.ifnmg.smrf.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "usuario", discriminatorType = DiscriminatorType.INTEGER)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Pessoa extends BaseEntity {

    @Column(length=100)
    private String nome;

    @Column(length=11)
    private String cpf;

    @Column
    private String rg;

    @Column
    private Usuario usuario;

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name="endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoaId", cascade = CascadeType.ALL)
    @Column(name = "email")
    private List<Email> emails;
    
    @OneToMany(mappedBy = "pessoaId", cascade = CascadeType.ALL)
    @Column(name = "telefone")
    private List<Telefone> telefones;

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }
}
