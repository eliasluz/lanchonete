package br.com.lanchonete.dao;

import java.util.List;

import br.com.lanchonete.model.Ingrediente;

public interface IngredienteDao extends AbstractDAO<Ingrediente>{

    List<Ingrediente> buscarLista();

}
