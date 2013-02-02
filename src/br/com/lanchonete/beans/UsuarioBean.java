package br.com.lanchonete.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.lanchonete.model.Usuario;
import br.com.lanchonete.service.UsuarioService;

public class UsuarioBean {

	private Usuario usuario;
	private UsuarioService usuarioService;
	private String senha;
	HttpSession sessao;
	HttpServletRequest request;

	public UsuarioBean() {
		setUsuario(new Usuario());
		usuarioService = new UsuarioService();
	}

	public String conferirLogin() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		String pagina = "";
		if (!usuario.getLogin().equals("") && !usuario.getSenha().equals("")) {
			setUsuario(usuarioService.conferirLoginSenha(usuario));
			if (getUsuario().getLogin() != null) {

				FacesContext context = FacesContext.getCurrentInstance();
				ExternalContext ec = context.getExternalContext();
				Object o = ec.getRequest();
				HttpServletRequest request = (HttpServletRequest) o;
				sessao = request.getSession();
				sessao.setAttribute("usuario", getUsuario());

				pagina = "principal";
			} else {
				int cont = usuarioService.buscaQuantidade();
				if (cont == 0) {
					pagina = "criaUsuario";
				} else {

					contexto.addMessage("f1:inputTextLogin", new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Login ou Senha Invalida",
							"Login ou Senha Invalida"));
				}
			}
		} else {
			contexto.addMessage("f1:inputTextLogin", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Login ou Senha Invalida",
					"Login ou Senha Invalida"));
		}
		return pagina;
	}

	public void addUsuario(ActionEvent evento) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		if (getSenha().equals(usuario.getSenha())) {

			boolean existe = usuarioService.verificaChave(usuario);
			if (!existe) {
				String nome = usuario.getNome().toUpperCase();
				usuario.setNome(nome);
				usuarioService.addUsuario(usuario);
			} else {
				contexto.addMessage("f1:inputTextLogin", new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Login já cadastrado",
						"Login invalido já cadastrado"));
			}
		} else {
			contexto.addMessage("f1:inputTextLogin", new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Senha e confirmação de senha diferentes",
					"Senha e confirmação de senha diferentes"));
		}
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
