package br.com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "codigo",sequenceName = "seq_codigo",allocationSize = 1)
public class Pessoa {
	
	@Column(name = "nome")
	private String nome;
	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "codigo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String senha;

	public Pessoa() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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
}
