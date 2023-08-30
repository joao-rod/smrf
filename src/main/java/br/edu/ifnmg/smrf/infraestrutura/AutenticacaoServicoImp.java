package br.edu.ifnmg.smrf.infraestrutura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.AutenticacaoServico;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;

@Service
@Scope("singleton")
public class AutenticacaoServicoImp implements AutenticacaoServico {
    private Pessoa usuario;

    @Autowired
    private PessoaRepositorio repositorio;

    public AutenticacaoServicoImp() {
        this.usuario = null;
    }

    @Override
    public boolean autenticar(String email, String senha) {
        try {
            usuario = repositorio.abrirPorEmail(email);

            return usuario != null && usuario.getSenha().equals(senha);

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Pessoa getUsuario() {
        return usuario;
    }
}