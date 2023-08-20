package br.edu.ifnmg.smrf.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "telefones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Telefone extends BaseEntity {

    @Column
    private Integer ddd;

    @Column(length = 12)
    private String numero;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Override
    public String toString() {
        return "Telefone [ddd=" + ddd + ", numero=" + numero + "]";
    }

}
