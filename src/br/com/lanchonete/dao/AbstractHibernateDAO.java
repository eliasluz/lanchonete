package br.com.lanchonete.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.lanchonete.util.HibernateUtil;


public abstract class AbstractHibernateDAO<T> implements AbstractDAO<T>{
	protected Session session = null;
	
	
	public void atualizar(T t) {
		session = getSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		fecha();		
	}
	/**
	 * metodo de excluir definitivamente do banco 
	 */
	public void excluirItemDobancoCuidado(T t) {
		session = getSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		fecha();		
	}
	/**
	 * Metodo de excluir atualizado
	 */
	public void excluir(T t){
		atualizar(t);
	}
	public void salvar(T t) {
		session = getSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		fecha();			
	}
	protected Session getSession(){
		try{
			session = HibernateUtil.getSessionFactory().openSession();
		}
		catch(HibernateException erro){
			erro.printStackTrace();
			fecha();
		}
		return session;
	}
	public void fecha(){
		session.close();
	}

}