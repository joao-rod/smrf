package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import br.edu.ifnmg.smrf.entidades.Condutor;
import br.edu.ifnmg.smrf.servicos.CondutorRepositorio;
import jakarta.persistence.Query;

public class CondutorDAO extends DAO<Condutor> implements CondutorRepositorio{
     public CondutorDAO(){
        super(Condutor.class);
    }

    @Override
    public List<Condutor> Buscar() {
        Query consulta = getManager().createQuery("select t from Condutor t");
        return (List<Condutor>) consulta.getResultList();
    }

    @Override
    public Condutor abrirPorCnh(String cnh) {
        Query consulta = getManager().createQuery("select t from Condutor t where t.nome = :p1");
        consulta.setParameter("p1", cnh);
        return (Condutor)consulta.getSingleResult();
    }

    @Override
    public List<Condutor> buscar(Condutor filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if(filtro.getCnh() != null){
            where += " t.cnh = :p1";
            parametros.add(filtro.getCnh());
        }


        Query consulta = getManager().createQuery("select t from Condutor t where " + where);


        if(where.length() > 0){
            int posicao = 0;
            for(Object parametro : parametros){
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return (List<Condutor>) consulta.getResultList();

    }
}
