package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.type.descriptor.java.LongJavaType;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Viagem;
import br.edu.ifnmg.smrf.servicos.ViagemRepositorio;
import jakarta.persistence.Query;

@Service
public class ViagemDAO extends DAO<Viagem> implements ViagemRepositorio {


    public ViagemDAO(){
        super(Viagem.class);
    }

    @Override
    public List<Viagem> Buscar() {
        Query consulta = getManager().createQuery("select t from Viagem t");
        return (List<Viagem>) consulta.getResultList();
    }

    @Override
    public Viagem abrirPorCondutores(String condutores) {
        Query consulta = getManager().createQuery("select t from Viagem t where t.condutores = :p1");
        consulta.setParameter("p1", condutores);
        return (Viagem)consulta.getSingleResult();
    }

    @Override
    public List<Viagem> buscar(Viagem filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if(filtro.getStatus() != null){
            where += " t.status = :p1";
            parametros.add(filtro.getStatus());
        }

        if(filtro.getData() != null){
            where += " t.data = :p2";
            parametros.add(filtro.getData());
        }

        if(filtro.getCondutores() != null){
            where += " t.condutor = :p3";
            parametros.add(filtro.getCondutores());
        }

        Query consulta = getManager().createQuery("select t from Viagem t where " + where);


        if(where.length() > 0){
            int posicao = 0;
            for(Object parametro : parametros){
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return (List<Viagem>) consulta.getResultList();

    }
    
}


