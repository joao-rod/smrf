package br.edu.ifnmg.smrf.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="viagem")
public class Viagem extends BaseEntity{
    @Id
    private long id;

    @Column
    private long condutor;
    
    @Column 
    private Date data;

    @Column
    @Enumerated
    private ViagemStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Viagem other = (Viagem) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Viagem [condutor=" + condutor + "]";
    }

    

}
