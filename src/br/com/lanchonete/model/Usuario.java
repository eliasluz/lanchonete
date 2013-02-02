package br.com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.lanchonete.enun.StatusRegistro;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	@Id	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="AC_CADASTRO")
	private boolean acCadastro;
	
	@Column(name="AC_VENDA")
	private boolean acVenda;
	
	@Column(name="AC_ESTOQUE")
	private boolean acEstoque;
	
	@Column(name="AC_FINANCEIRO")
	private boolean acFinanceiro;
	
	@Column(name="AC_CONTROLEDEACESSO")
	private boolean acControleDeAcesso;
	
	/**
	 * Criando variavel Status 
	 * criando get set hashcode
	 * equals
	 */
	@Column(name = "ST_REGISTRO")
	private String stRegistro = StatusRegistro.ATIVO.getCodigo();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAcCadastro() {
		return acCadastro;
	}

	public void setAcCadastro(boolean acCadastro) {
		this.acCadastro = acCadastro;
	}

	public boolean isAcVenda() {
		return acVenda;
	}

	public void setAcVenda(boolean acVenda) {
		this.acVenda = acVenda;
	}

	public boolean isAcEstoque() {
		return acEstoque;
	}

	public void setAcEstoque(boolean acEstoque) {
		this.acEstoque = acEstoque;
	}

	public boolean isAcFinanceiro() {
		return acFinanceiro;
	}

	public void setAcFinanceiro(boolean acFinanceiro) {
		this.acFinanceiro = acFinanceiro;
	}

	public boolean isAcControleDeAcesso() {
		return acControleDeAcesso;
	}

	public void setAcControleDeAcesso(boolean acControleDeAcesso) {
		this.acControleDeAcesso = acControleDeAcesso;
	}

	public String getStRegistro() {
		return stRegistro;
	}

	public void setStRegistro(String stRegistro) {
		this.stRegistro = stRegistro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}
}
