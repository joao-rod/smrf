package br.edu.ifnmg.smrf.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cnhs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Cnh extends BaseEntity {

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @Column(name = "data_validade")
    private Date dataValidade;

}
