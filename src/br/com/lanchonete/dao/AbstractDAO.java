package br.com.lanchonete.dao;


public interface AbstractDAO<T> {
	public void salvar(T t);
	public void atualizar(T t);
	public void excluirItemDobancoCuidado(T t);
	public void excluir(T t);
}
