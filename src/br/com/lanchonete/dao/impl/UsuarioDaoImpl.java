package br.com.lanchonete.dao.impl;

import java.util.List;

import org.hibernate.Query;

import br.com.lanchonete.dao.AbstractHibernateDAO;
import br.com.lanchonete.dao.UsuarioDAO;
import br.com.lanchonete.enun.StatusRegistro;
import br.com.lanchonete.model.Usuario;

public class UsuarioDaoImpl extends AbstractHibernateDAO<Usuario> implements UsuarioDAO{

	public Usuario conferirLoginSenha(Usuario usuario) {

		StringBuilder hql = new StringBuilder();

		hql.append("FROM Usuario u WHERE u.login = :log AND u.senha = :senha ");
		hql.append("AND u.stRegistro = :status");
		
		session = getSession();
		Query query = session.createQuery(hql.toString());
		query.setParameter("log", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		query.setParameter("status", StatusRegistro.ATIVO.getCodigo());
		
		Usuario usuarioConfere = (Usuario) query.uniqueResult();
		if(usuarioConfere == null ){
			return new Usuario();
		}
		fecha();
		return usuarioConfere;
	}

	@SuppressWarnings("unchecked")
	public int buscaQuantidade() {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT u ");
		hql.append("FROM Usuario u ");
		hql.append("WHERE u.stRegistro = :status");
		
		session = getSession();
		Query query = session.createQuery(hql.toString());
		query.setParameter("status", StatusRegistro.ATIVO.getCodigo());

		List<Usuario> lista = query.list();
		
		int cont = lista.size();
		fecha();
		return cont;
	}

	public boolean verificaChave(Usuario usuario) {
		
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT u ");
		hql.append("FROM Usuario u ");
		hql.append("WHERE u.login = :login");
		
		session = getSession();
		Query query = session.createQuery(hql.toString());
		
		query.setParameter("login", usuario.getLogin());
		
		Usuario u = (Usuario) query.uniqueResult();
		
		if(u != null){
			return true;
		}		
		fecha();
		return false;
	}

	public Usuario buscaUsuarioPorLogin(String login) {
		
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT u FROM Usuario u ");
		hql.append("WHERE u.login = :login ");
		hql.append("AND u.stRegistro = :status ");
	
		session = getSession();
		Query query = session.createQuery(hql.toString());
		
		query.setParameter("login", login);
		query.setParameter("status", StatusRegistro.ATIVO.getCodigo());
		Usuario usuario  = (Usuario) query.uniqueResult();
		
		fecha();
		
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscaListaDeUsuarioCadastrado() {
		StringBuilder hql = new StringBuilder();
		
		session = getSession();
		
		hql.append("FROM Usuario");
		Query query = session.createQuery(hql.toString());
		
		List<Usuario> lista = query.list();
		
		fecha();
		return lista;
	}

}
