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
@Table(name = "viagens")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Viagem extends BaseEntity {

    @OneToMany
    private List<Condutor> condutores;

    @OneToMany
    private List<Veiculo> veiculos;

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

    public void addCondutor(Condutor c) {
        if (this.condutores == null)
            this.condutores = new ArrayList<>();

        if (c != null)
            this.condutores.add(c);
    }

    public void removeCondutor(Condutor c) {
        if (this.condutores.contains(c))
            this.condutores.remove(c);
    }
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculo) {
        this.veiculos = veiculo;
    }

    public void addVeiculo(Veiculo c) {
        if (this.veiculos == null)
            this.veiculos = new ArrayList<>();

        if (c != null)
            this.veiculos.add(c);
    }

    public void removeVeiculo(Veiculo c) {
        if (this.veiculos.contains(c))
            this.veiculos.remove(c);
    }
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ViagemStatus getStatus() {
        return status;
    }

    public void setStatus(ViagemStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Viagem [condutor=" + getId() + "]";
    }
}
