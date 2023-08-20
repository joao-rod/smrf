package br.edu.ifnmg.smrf.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="viagens")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Viagem extends BaseEntity {

    public void setStatus(ViagemStatus status) {
        this.status = status;
    }

    @OneToMany
    private List<Condutor> condutores;
    
    @Column 
    private Date data;

    @Column
    @Enumerated
    private ViagemStatus status;

    public List<Condutor> getCondutores() {
        return condutores;
    }

    public void setCondutores(List<Condutor> condutor) {
        this.condutores = condutor;
    }

    public void addCondutor(Condutor c){
        if(this.condutores == null)
            this.condutores = new ArrayList<>();

        if(c != null)
            this.condutores.add(c);
    }

    public void removeCondutor(Condutor c){
        if(this.condutores.contains(c))
            this.condutores.remove(c);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Viagem [condutor=" + getId() + "]";
    }

    public ViagemStatus getStatus() {
        return status;
    }

}
