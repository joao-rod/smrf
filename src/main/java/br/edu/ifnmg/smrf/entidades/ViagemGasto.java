package br.edu.ifnmg.smrf.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "viagem_gastos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class ViagemGasto extends BaseEntity {

    @Column
    private String placa;

    @Column
    private Double valor;

    @Column
    @Enumerated
    private TipoGasto tipoGasto;

    @Column 
    private String notaFiscal;

    @Override
    public String toString() {
        return "ViagemGasto [tipoGasto=" + tipoGasto + "]";
    }
}
