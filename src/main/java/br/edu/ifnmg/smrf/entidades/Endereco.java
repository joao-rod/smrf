package br.edu.ifnmg.smrf.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Endereco extends BaseEntity {

    @Column
    private String logradouro;

    @Column
    private String numero;

    @Column
    private String bairro;

    @Column
    private String complemento;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}