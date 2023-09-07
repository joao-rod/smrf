package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Endereco;
import br.edu.ifnmg.smrf.entidades.Pessoa;

public interface EnderecoRepositorio extends Repositorio<Endereco>{
    public Endereco abrirPorBairro(String bairro);
    public Endereco abrirPorUsuario(Pessoa pessoa);
}
