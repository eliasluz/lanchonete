package br.com.lanchonete.dao.impl;

import java.util.List;

import org.hibernate.Query;

import br.com.lanchonete.dao.AbstractHibernateDAO;
import br.com.lanchonete.dao.LancheDAO;
import br.com.lanchonete.enun.StatusRegistro;
import br.com.lanchonete.model.Lanche;

public class LancheDaoImpl extends AbstractHibernateDAO<Lanche> implements
	LancheDAO {

    @SuppressWarnings("unchecked")
    public List<Lanche> buscarLista() {
	StringBuilder hql = new StringBuilder();

	hql.append("FROM lanche l ");
	hql.append("WHERE l.stRegistro = :status ");

	session = getSession();

	Query query = session.createQuery(hql.toString());
	query.setParameter("status", StatusRegistro.ATIVO.getCodigo());

	List<Lanche> lista = query.list();

	fecha();

	return lista;
    }

}
