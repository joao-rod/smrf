package br.edu.ifnmg.smrf.infraestrutura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Usuario;
import br.edu.ifnmg.smrf.servicos.AutenticacaoServico;
import br.edu.ifnmg.smrf.servicos.UsuarioRepositorio;
import jakarta.persistence.NoResultException;

@Service
@Scope("singleton")
public class AutenticacaoServicoImp implements AutenticacaoServico {
    private Usuario usuario;

    @Autowired
    private UsuarioRepositorio repositorio;

    public AutenticacaoServicoImp() {
        this.usuario = null;
    }

    @Override
    public boolean autenticar(String email, String senha) {
        try {
            usuario = repositorio.abrirPorEmail(email);

            return usuario != null && usuario.getSenha().equals(senha);

        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }
}