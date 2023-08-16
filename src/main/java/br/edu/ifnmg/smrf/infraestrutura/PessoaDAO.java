package br.edu.ifnmg.smrf.infraestrutura;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.smrf.entidades.Pessoa;
import br.edu.ifnmg.smrf.servicos.PessoaRepositorio;
import jakarta.persistence.Query;

@Service
public class PessoaDAO extends DAO<Pessoa> implements PessoaRepositorio{
    public PessoaDAO(){
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> Buscar() {
        Query consulta = getManager().createQuery("select t from Pessoa t");
        return (List<Pessoa>) consulta.getResultList();
    }

    @Override
    public Pessoa abrirPorNome(String nome) {
        Query consulta = getManager().createQuery("select t from Pessoa t where t.nome = :p1");
        consulta.setParameter("p1", nome);
        return (Pessoa)consulta.getSingleResult();
    }

    @Override
    public List<Pessoa> buscar(Pessoa filtro) {

        String where = "";
        List<Object> parametros = new LinkedList<Object>();

        if(filtro.getCpf() != ""){
            where += " t.cpf = :p1";
            parametros.add(filtro.getCpf());
        }

        if(filtro.getRg() != null){
            if(where.length() > 0) where += " and ";

            where += " t.modelo = :p2";
            parametros.add(filtro.getRg());
        }

        if(filtro.getNome() != ""){
            if(where.length() > 0) where += " and ";
            
            where += " t.placa = :p3";
            parametros.add(filtro.getNome());
        }

        Query consulta = getManager().createQuery("select t from Pessoa t where " + where);


        if(where.length() > 0){
            int posicao = 0;
            for(Object parametro : parametros){
                posicao++;
                consulta.setParameter(posicao, parametro);
            }
        }

        return (List<Pessoa>) consulta.getResultList();

    }
}
