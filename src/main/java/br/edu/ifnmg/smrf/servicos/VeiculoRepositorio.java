package br.edu.ifnmg.smrf.servicos;

import java.util.List;

import br.edu.ifnmg.smrf.entidades.Veiculo;

public interface VeiculoRepositorio extends Repositorio<Veiculo>{
    public Veiculo abrirPorPlaca(String placa);
    public List<String> buscarPlacas();
}