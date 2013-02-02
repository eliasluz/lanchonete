package br.com.lanchonete.dao;

import java.util.List;

import br.com.lanchonete.model.Lanche;


public interface LancheDAO extends AbstractDAO<Lanche> {

    List<Lanche> buscarLista();

}
