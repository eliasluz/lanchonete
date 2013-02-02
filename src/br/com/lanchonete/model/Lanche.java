package br.com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.lanchonete.enun.StatusRegistro;
import br.com.lanchonete.model.rl.RLLancheIngrediente;

@Entity
@Table(name = "TB_LANCHE")
@SequenceGenerator(name = "codigo", sequenceName = "SEQ_CODIGO_LANCHE", allocationSize = 1)
public class Lanche {

	@Id
	@Column(name = "CODIGO")
	@GeneratedValue(generator = "codigo", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(value = {
			@JoinColumn(name = "COD_LANCHE", referencedColumnName = "COD_LANCHE"),
			@JoinColumn(name = "COD_INGREDIENTE", referencedColumnName = "COD_INGREDIENTE") })
	private RLLancheIngrediente lancheIngrediente;

	@Column(name = "NOME")
	private String nome;

	/**
	 * Criando preco
	 */
	@Column(name = "PRECO")
	private double preco;

	@Column(name = "ST_REGISTRO")
	private String stRegistro = StatusRegistro.ATIVO.getCodigo();

	/**
	 * Criando get set hashcode equals
	 */

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public RLLancheIngrediente getLancheIngrediente() {
		return lancheIngrediente;
	}

	public void setLancheIngrediente(RLLancheIngrediente lancheIngrediente) {
		this.lancheIngrediente = lancheIngrediente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
		result = prime * result + codigo;
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
		Lanche other = (Lanche) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}
