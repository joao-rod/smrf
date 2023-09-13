package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Condutor;
import java.util.List;

public interface CondutorRepositorio  extends Repositorio<Condutor>{
    public Condutor abrirPorCnh(String cnh);
    public List<String> buscarNome();
}
