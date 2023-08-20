package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Cnh;

public interface CnhRepositorio  extends Repositorio<Cnh>{
    public Cnh abrirPorCategoria(String categoria);
}

