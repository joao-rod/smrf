package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Pessoa;

public interface PessoaRepositorio extends Repositorio<Pessoa>{
    public Pessoa abrirPorCpf(String cpf);
}
