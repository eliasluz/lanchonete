package br.com.lanchonete.dao.impl;

import java.util.List;

import org.hibernate.Query;

import br.com.lanchonete.dao.AbstractHibernateDAO;
import br.com.lanchonete.dao.IngredienteDao;
import br.com.lanchonete.enun.StatusRegistro;
import br.com.lanchonete.model.Ingrediente;

public class IngredienteDaoImpl extends AbstractHibernateDAO<Ingrediente> implements IngredienteDao{

    @SuppressWarnings("unchecked")
    public List<Ingrediente> buscarLista() {
	
	StringBuilder hql = new StringBuilder();
	
	hql.append("FROM Ingrediente i ");
	hql.append("WHERE i.stRegistro = :status ");
	
	session = getSession();
	
	Query query = session.createQuery(hql.toString());
	query.setParameter("status", StatusRegistro.ATIVO.getCodigo());
	
	List<Ingrediente> lista = query.list();
	
	fecha();
	
	return lista;
    }

}
