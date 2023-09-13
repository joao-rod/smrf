package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Veiculo;
import br.edu.ifnmg.smrf.servicos.VeiculoRepositorio;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Service
public class VeiculoDAO extends DAO<Veiculo> implements VeiculoRepositorio {

    public VeiculoDAO() {
        super(Veiculo.class);
    }

    @Override
    public List<Veiculo> Buscar() {
        TypedQuery<Veiculo> consulta = getManager().createQuery("select t from Veiculo t", Veiculo.class);
        return consulta.getResultList();
    }

    @Override
    public Veiculo abrirPorPlaca(String placa) {
        Query consulta = getManager().createQuery("select t from Veiculo t where t.placa = :p1");
        consulta.setParameter("p1", placa);
        return (Veiculo) consulta.getSingleResult();
    }

    @Override
    public List<Veiculo> buscar(Veiculo filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if (filtro.getAno() != 0) {
            where += " t.ano = :p1";
            parametros.add(filtro.getAno());
        }

        if (filtro.getModelo() != null) {
            if (where.length() > 0)
                where += " and ";

            where += " t.modelo = :p2";
            parametros.add(filtro.getModelo());
        }

        if (filtro.getPlaca() != null) {
            if (where.length() > 0)
                where += " and ";

            where += " t.placa = :p3";
            parametros.add(filtro.getPlaca());
        }

        TypedQuery<Veiculo> consulta = getManager().createQuery("select t from Veiculo t where " + where, Veiculo.class);

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
    public List<String> buscarPlacas() {
        TypedQuery<String> consulta = getManager().createQuery("select v.placa from Veiculo v", String.class);
        return consulta.getResultList();
    }

}
