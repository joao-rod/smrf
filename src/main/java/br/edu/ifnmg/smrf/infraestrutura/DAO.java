package br.edu.ifnmg.smrf.infraestrutura;

import java.util.List;

import br.edu.ifnmg.smrf.servicos.Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class DAO<T> implements Repositorio<T> {
    
    @PersistenceContext
    private EntityManager manager;
    private Class<T> classe;
    
    public DAO(Class<T> classe){
        this.classe = classe;
    }

    public EntityManager getManager(){
        return manager;
    }

    public Class<T> getClasse(){
        return classe;
    }

    @Override
    public T Abrir(Long id){
        try{
            return (T) manager.find(this.classe,id);
        } catch(Exception ex){
            return null;
        }
    }

    @Override
    @Transactional
    public boolean Salvar(T obj){
        try{
            obj = manager.merge(obj);
            manager.flush();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    @Transactional
    public boolean Apagar(T obj){
        try {
            manager.remove(obj);
            manager.flush();
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    // @Override
    // public List<T> buscar(String nome) {
    //     Query consulta = manager
    //             .createQuery("select t from T t where nome = :p0");
    //     return consulta
    //             .setParameter("p0", nome)
    //             .getResultList();
    // }
    // @Override
    // public List<T> Buscar() {
    //     Query consulta = manager.createQuery("select t from T t");

    //     return consulta.getResultList();
    // }

}
