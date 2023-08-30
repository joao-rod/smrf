package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import jakarta.persistence.Query;

@Service
public class PessoaDAO extends DAO<Pessoa> implements PessoaRepositorio {

    public PessoaDAO() {
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> Buscar() {
        Query consulta = getManager().createQuery("select p from Pessoa p");
        return (List<Pessoa>) consulta.getResultList();
    }

    @Override
    public Pessoa abrirPorCpf(String cpf) {
        Query consulta = getManager().createQuery("select p from Pessoa p where p.cpf = :p1");
        consulta.setParameter("p1", cpf);
        return (Pessoa) consulta.getSingleResult();
    }

    @Override
    public Pessoa abrirPorEmail(String email) {
        Query consulta = getManager().createQuery("select p from Pessoa p where p.email = :p1");
        consulta.setParameter("p1", email);
        return (Pessoa) consulta.getSingleResult();

    }

    @Override
    public List<Pessoa> buscar(Pessoa filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if (filtro.getCpf() != "") {
            where += " p.cpf = :p1";
            parametros.add(filtro.getCpf());
        }

        if (filtro.getRg() != null) {
            if (where.length() > 0)
                where += " and ";

            where += " p.modelo = :p2";
            parametros.add(filtro.getRg());
        }

        if (filtro.getNome() != "") {
            if (where.length() > 0)
                where += " and ";

            where += " p.placa = :p3";
            parametros.add(filtro.getNome());
        }

        if(filtro.getEmail() != ""){
            where += " p.cpf = :p";
            parametros.add(filtro.getEmail());
        }

        Query consulta = getManager().createQuery("select p from Pessoa p where " + where);

        if (where.length() > 0) {
            int posicao = 0;
            for (Object parametro : parametros) {
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return (List<Pessoa>) consulta.getResultList();

    }
}
