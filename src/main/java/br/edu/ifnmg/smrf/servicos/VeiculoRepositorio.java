package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Veiculo;

public interface VeiculoRepositorio extends Repositorio<Veiculo>{
    public Veiculo abrirPorPlaca(String placa);
}