package br.com.crescer.aula3.jdbc;

import java.util.List;

public interface IPessoa {
    void insert(Pessoa p);
    void update(Pessoa p);
    void delete(Pessoa p);
    List<Pessoa> listAll();
    List<Pessoa> findNome(String nome);
}
