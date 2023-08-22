package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import br.edu.ifnmg.smrf.entidades.Cnh;
import br.edu.ifnmg.smrf.servicos.CnhRepositorio;
import jakarta.persistence.Query;

public class CnhDAO extends DAO<Cnh> implements CnhRepositorio {


    public CnhDAO(){
        super(Cnh.class);
    }

    @Override
    public List<Cnh> Buscar() {
        Query consulta = getManager().createQuery("select t from Cnh t");
        return (List<Cnh>) consulta.getResultList();
    }

    @Override
    public Cnh abrirPorCategoria(String categoria) {
        Query consulta = getManager().createQuery("select t from Cnh t where t.categoria = :p1");
        consulta.setParameter("p1", categoria);
        return (Cnh)consulta.getSingleResult();
    }

    @Override
    public List<Cnh> buscar(Cnh filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if(filtro.getDataEmissao() != null){
            where += " t.dataEmissao = :p1";
            parametros.add(filtro.getDataEmissao());
        }

        if(filtro.getDataValidade() != null){
            where += " t.modelo = :p2";
            parametros.add(filtro.getDataValidade());
        }

        if(filtro.getCategoria() != ""){
            where += " t.categoria = :p3";
            parametros.add(filtro.getCategoria());
        }

        if(filtro.getCondutor() != null){
            where += " t.condutor = :p3";
            parametros.add(filtro.getCondutor());
        }

        Query consulta = getManager().createQuery("select t from Cnh t where " + where);


        if(where.length() > 0){
            int posicao = 0;
            for(Object parametro : parametros){
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return (List<Cnh>) consulta.getResultList();

    }
    
}