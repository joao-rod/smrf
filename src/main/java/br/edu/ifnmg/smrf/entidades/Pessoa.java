package br.edu.ifnmg.smrf.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Pessoa extends BaseEntity {

    @Column(length=100)
    private String nome;

    @Column(length=11)
    private String cpf;

    @Column
    private String rg;

    @OneToOne
    private Pessoa pessoa;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, targetEntity = Endereco.class)
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, targetEntity = Email.class)
    private List<Email> emails;
    
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, targetEntity = Telefone.class)
    private List<Telefone> telefones;

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }

}
