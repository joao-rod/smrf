package br.edu.ifnmg.smrf.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="viagem")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Viagem extends BaseEntity {

    @Column
    private long condutor;
    
    @Column 
    private Date data;

    @Column
    @Enumerated
    private ViagemStatus status;

    public long getCondutor() {
        return condutor;
    }

    public void setCondutor(long condutor) {
        this.condutor = condutor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Viagem [condutor=" + condutor + "]";
    }

}
