package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Cnh;
import br.edu.ifnmg.smrf.entidades.Condutor;

public interface CnhRepositorio  extends Repositorio<Cnh>{
    public Cnh abrirPorCategoria(String categoria);
    public Cnh abrirPorCondutor(Condutor condutor);
}

