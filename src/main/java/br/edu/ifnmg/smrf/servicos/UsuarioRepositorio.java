package br.edu.ifnmg.smrf.servicos;

import br.edu.ifnmg.smrf.entidades.Usuario;

public interface UsuarioRepositorio extends Repositorio<Usuario>{
    public Usuario abrirPorEmail(String email);
}
