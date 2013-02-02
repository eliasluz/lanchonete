package br.com.lanchonete.dao;

import br.com.lanchonete.dao.impl.IngredienteDaoImpl;
import br.com.lanchonete.dao.impl.LancheDaoImpl;
import br.com.lanchonete.dao.impl.UsuarioDaoImpl;

public class DAOFactory {
	@SuppressWarnings("rawtypes")
	public static AbstractDAO getDAO(String texto) {

		if("Usuario".equals(texto)){
			return new UsuarioDaoImpl();
		}
		if("Ingrediente".equals(texto)){
			return new IngredienteDaoImpl();
		}
		if("Lanche".equals(texto)){
		    return new LancheDaoImpl();
		}
		return null;
	}
}
