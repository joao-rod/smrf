package br.edu.ifnmg.smrf.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address", length = 100)
    private String addr;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoaId;

    public Email(String addr) {
        this.id = 0L;
        this.addr = addr;
        this.pessoaId = null;
    }

    @Override
    public String toString() {
        return "Email [email=" + addr + "]";
    }
}
