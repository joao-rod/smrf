package br.edu.ifnmg.smrf.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "condutores")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Condutor extends BaseEntity {

    @OneToOne(targetEntity = Cnh.class)
    @JoinColumn(name = "cnh")
    private Cnh cnh;

    @OneToOne
    private Pessoa condutor;

    @Override
    public String toString() {
        return "Condutor [cnh=" + cnh + "]";
    }
}
