package br.edu.ifnmg.smrf.servicos;

import java.util.List;

import br.edu.ifnmg.smrf.entidades.Condutor;
import br.edu.ifnmg.smrf.entidades.Pessoa;

public interface CondutorRepositorio  extends Repositorio<Condutor>{
    public Condutor abrirPorCnh(String cnh);
    public List<String> buscarNome();
    public Condutor abrirPorUsuario(Pessoa pessoa);
}
