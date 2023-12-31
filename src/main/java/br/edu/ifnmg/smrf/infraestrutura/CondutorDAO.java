package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Condutor;
import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.CondutorRepositorio;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Service
public class CondutorDAO extends DAO<Condutor> implements CondutorRepositorio {
    public CondutorDAO() {
        super(Condutor.class);
    }

    @Override
    public List<Condutor> Buscar() {
        TypedQuery<Condutor> consulta = getManager().createQuery("select t from Condutor t", Condutor.class);
        return consulta.getResultList();
    }

    @Override
    public Condutor abrirPorCnh(String cnh) {
        Query consulta = getManager().createQuery("select t from Condutor t where t.cnh = :p1");
        consulta.setParameter("p1", cnh);
        return (Condutor) consulta.getSingleResult();
    }

    @Override
    public List<Condutor> buscar(Condutor filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if (filtro.getCnh() != null) {
            where += " t.cnh = :p1";
            parametros.add(filtro.getCnh());
        }

        TypedQuery<Condutor> consulta = getManager().createQuery("select t from Condutor t where " + where, Condutor.class);

        if (where.length() > 0) {
            int posicao = 0;
            for (Object parametro : parametros) {
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return consulta.getResultList();

    }

    @Override
    public List<String> buscarNome() {
        TypedQuery<String> consulta = getManager().createQuery("select u.nome from Condutor c join c.condutor u", String.class);
        return consulta.getResultList();
    }

    @Override
    public Condutor abrirPorUsuario(Pessoa pessoa) {
        Query consulta = getManager().createQuery("select c from Condutor c where c.condutor = :c1");
        consulta.setParameter("c1", pessoa);
        return (Condutor) consulta.getSingleResult();

    }
}
