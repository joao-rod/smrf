package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Viagem;

public interface ViagemRepositorio extends Repositorio<Viagem>{
    public Viagem abrirPorCondutores(String condutores);
}
