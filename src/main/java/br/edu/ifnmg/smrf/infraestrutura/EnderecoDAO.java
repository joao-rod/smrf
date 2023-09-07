package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Endereco;
import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.EnderecoRepositorio;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Service
public class EnderecoDAO extends DAO<Endereco> implements EnderecoRepositorio {

    public EnderecoDAO() {
        super(Endereco.class);
    }

    @Override
    public List<Endereco> Buscar() {
        TypedQuery<Endereco> consulta = getManager().createQuery("select e from Endereco e", Endereco.class);
        return consulta.getResultList();
    }

    @Override
    public Endereco abrirPorBairro(String bairro) {
        Query consulta = getManager().createQuery("select e from Endereco e where e.bairro = :e1");
        consulta.setParameter("e1", bairro);
        return (Endereco) consulta.getSingleResult();
    }

    @Override
    public Endereco abrirPorUsuario(Pessoa pessoa) {
        Query consulta = getManager().createQuery("select e from Endereco e where e.pessoa = :e1");
        consulta.setParameter("e1", pessoa);
        return (Endereco) consulta.getSingleResult();

    }

    @Override
    public List<Endereco> buscar(Endereco filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if (filtro.getLogradouro() != "") {
            where += " e.logradouro = :e1";
            parametros.add(filtro.getLogradouro());
        }

        if (filtro.getNumero() != null) {
            if (where.length() > 0)
                where += " and ";

            where += " e.numero = :e2";
            parametros.add(filtro.getNumero());
        }

        if (filtro.getBairro() != "") {
            if (where.length() > 0)
                where += " and ";

            where += " e.placa = :e3";
            parametros.add(filtro.getBairro());
        }

        if (filtro.getComplemento() != "") {
            where += " e.complemento = :e";
            parametros.add(filtro.getComplemento());
        }

        TypedQuery<Endereco> consulta = getManager().createQuery("select e from Endereco e where " + where,
                Endereco.class);

        if (where.length() > 0) {
            int posicao = 0;
            for (Object parametro : parametros) {
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return consulta.getResultList();
    }
}
