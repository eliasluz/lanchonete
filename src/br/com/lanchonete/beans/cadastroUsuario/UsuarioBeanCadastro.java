package br.com.lanchonete.beans.cadastroUsuario;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.lanchonete.model.Usuario;
import br.com.lanchonete.service.UsuarioService;

public class UsuarioBeanCadastro {
	
	private Usuario usuario;
	
	private Usuario usuarioCadastro;
	
	private String senha;
	
	private int page = 1;
	
	private List<Usuario> listaUsuario;
	
	private UsuarioService usuarioService;
	
	HttpSession sessao;
	HttpServletRequest request;
	
	public UsuarioBeanCadastro(){
		usuarioCadastro = new Usuario();
		usuarioService = new UsuarioService();
		preencheListaUsuario();
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
	
	public void addUsuario(ActionEvent evento) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		if (getSenha().equals(usuarioCadastro.getSenha())) {

			boolean existe = usuarioService.verificaChave(usuarioCadastro);
			if (!existe) {
				String nome = usuarioCadastro.getNome().toUpperCase();
				usuarioCadastro.setNome(nome);
				usuarioService.addUsuario(usuarioCadastro);
				
				preencheListaUsuario();
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
		usuarioCadastro = new Usuario();
	}
	
	private void preencheListaUsuario() {
		listaUsuario = usuarioService.buscaListaDeUsuarioCadastrado();		
	}		
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}
	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
