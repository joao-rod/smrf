package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Usuario;
import br.edu.ifnmg.smrf.servicos.UsuarioRepositorio;
import jakarta.persistence.Query;

@Service
public class UsuarioDAO extends DAO<Usuario> implements UsuarioRepositorio {
    
    public UsuarioDAO(){
        super(Usuario.class);
    }

    @Override
    public List<Usuario> Buscar() {
        Query consulta = getManager().createQuery("select u from Usuario u");
        return (List<Usuario>) consulta.getResultList();
    }

    @Override
    public Usuario abrirPorEmail(String email) {
        Query consulta = getManager().createQuery("select u from Usuario u where u.email = :p1");
        consulta.setParameter("p1", email);
        return (Usuario)consulta.getSingleResult();
    }

    @Override
    public List<Usuario> buscar(Usuario filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if(filtro.getEmail() != ""){
            where += " u.cpf = :p1";
            parametros.add(filtro.getEmail());
        }

        Query consulta = getManager().createQuery("select u from Pessoa u where " + where);

        if(where.length() > 0){
            int posicao = 0;
            for(Object parametro : parametros){
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return (List<Usuario>) consulta.getResultList();

    }
}
