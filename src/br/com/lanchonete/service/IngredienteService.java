package br.com.lanchonete.service;

import java.util.List;

import br.com.lanchonete.dao.DAOFactory;
import br.com.lanchonete.dao.IngredienteDao;
import br.com.lanchonete.model.Ingrediente;

public class IngredienteService {

	private String texto = "Ingrediente";
	private IngredienteDao ingredienteDao = (IngredienteDao) DAOFactory.getDAO(texto);
	
	public void salvar(Ingrediente ingrediente){
	    ingredienteDao.salvar(ingrediente);
	}

	public List<Ingrediente> buscarLista() {

	    return ingredienteDao.buscarLista();
	}
}
