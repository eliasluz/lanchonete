package br.com.lanchonete.service;

import java.util.List;

import br.com.lanchonete.dao.DAOFactory;
import br.com.lanchonete.dao.LancheDAO;
import br.com.lanchonete.model.Lanche;

public class LancheService {

	private String texto = "Lanche";
	private LancheDAO lancheDao = (LancheDAO) DAOFactory.getDAO(texto);
	
	
	public List<Lanche> buscarLista() {
	    return lancheDao.buscarLista();
	}
}
