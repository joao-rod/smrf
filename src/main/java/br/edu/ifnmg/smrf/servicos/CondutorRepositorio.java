package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Condutor;

public interface CondutorRepositorio  extends Repositorio<Condutor>{
    public Condutor abrirPorCnh(String cnh);
}
