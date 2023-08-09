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
@Table(name = "emails")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Email extends BaseEntity {

    @Column(name = "address", length = 100)
    private String addr;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaId;

    public Email(String addr) {
        this.setId(0L);
        this.addr = addr;
        this.pessoaId = null;
    }

    @Override
    public String toString() {
        return "Email [email=" + addr + "]";
    }
}
