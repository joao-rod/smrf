package br.edu.ifnmg.smrf.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="veiculos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Veiculo extends BaseEntity {

    @Column
    private String placa;

    @Column
    private String modelo;

    @Column
    private String ano;

    @Column
    private String renavan;

    @Column
    private String fabricante;

    @Column
    private String descricao;

    @Column
    private LocalDate dataDeAquisicao;

    @Override
    public String toString() {
        return "Veiculo [placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", renavan=" + renavan
                + ", fabricante=" + fabricante + ", descricao=" + descricao + ", dataDeAquisicao=" + dataDeAquisicao
                + "]";
    }
}
