package br.com.lanchonete.dao;

import java.util.List;

import br.com.lanchonete.model.Usuario;


public interface UsuarioDAO extends AbstractDAO<Usuario>{

	Usuario conferirLoginSenha(Usuario usuario);

	int buscaQuantidade();

	boolean verificaChave(Usuario usuario);

	Usuario buscaUsuarioPorLogin(String login);

	List<Usuario> buscaListaDeUsuarioCadastrado();

}
