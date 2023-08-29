package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Pessoa;

public interface AutenticacaoServico {
    public boolean autenticar(String email, String senha);
    public Pessoa getUsuario();
}
