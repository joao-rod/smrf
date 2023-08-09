package br.edu.ifnmg.smrf.servicos;

import java.util.List;

public interface Repositorio<T> {
    public T Abrir(Long id);
    public boolean Salvar(T obj);
    public boolean Apagar(T obj);
    public List<T> Buscar();
}
