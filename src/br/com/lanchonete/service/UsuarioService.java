package br.com.lanchonete.service;

import java.util.List;

import br.com.lanchonete.dao.DAOFactory;
import br.com.lanchonete.dao.UsuarioDAO;
import br.com.lanchonete.model.Usuario;

public class UsuarioService {

	private String texto = "Usuario";
	private UsuarioDAO usuarioDao = (UsuarioDAO) DAOFactory.getDAO(texto);

	public Usuario conferirLoginSenha(Usuario usuario) {

		return usuarioDao.conferirLoginSenha(usuario);
	}

	public int buscaQuantidade() {

		return usuarioDao.buscaQuantidade();
	}

	public void addUsuario(Usuario usuario) {
		usuarioDao.salvar(usuario);
	}

	public boolean verificaChave(Usuario usuario) {

		return usuarioDao.verificaChave(usuario);
	}

	public Usuario buscaUsuarioPorLogin(String login) {
		return usuarioDao.buscaUsuarioPorLogin(login);
	}

	public List<Usuario> buscaListaDeUsuarioCadastrado() {

		return usuarioDao.buscaListaDeUsuarioCadastrado();
	}

}
