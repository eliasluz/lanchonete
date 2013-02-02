package br.com.lanchonete.beans;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.lanchonete.model.Usuario;

public class PaginaInicialBean {
	
	private Usuario usuario;
	HttpSession sessao;
	HttpServletRequest request;
	
	
	
	public PaginaInicialBean(){
		verificaLogin();
	}
	
	private void verificaLogin(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		Object o = ec.getRequest();
		HttpServletRequest request = (HttpServletRequest) o;
		sessao = request.getSession();
		setUsuario((Usuario) sessao.getAttribute("usuario"));
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
