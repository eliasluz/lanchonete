package br.com.lanchonete.model.rl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.lanchonete.enun.StatusRegistro;
import br.com.lanchonete.model.Ingrediente;
import br.com.lanchonete.model.Lanche;

@Entity
@Table(name="RL_LANCHE_INGREDIENTE")
public class RLLancheIngrediente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2064899212168214L;

	@EmbeddedId
	private RLLancheIngredientePk pk;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_LANCHE", insertable = false, updatable = false)
	private Lanche lanche;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_INGREDIENTE", insertable = false, updatable = false)
	private Ingrediente ingrediente;

	@Column(name="UNIDADE")
	private String unidade;
	
	@Column(name="QUANTIDADE")
	private int quantidade;
	
	
	/**
	 * criando variavel stRegistro
	 */
	@Column(name="ST_REGISTRO")
	private String stRegistro = StatusRegistro.ATIVO.getCodigo();
	
	/**
	 * Criando os get set hashcode equal
	 * @return
	 */
	public RLLancheIngredientePk getPk() {
		return pk;
	}

	public void setPk(RLLancheIngredientePk pk) {
		this.pk = pk;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getStRegistro() {
		return stRegistro;
	}

	public void setStRegistro(String stRegistro) {
		this.stRegistro = stRegistro;
	}
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Lanche getLanche() {
		return lanche;
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		RLLancheIngrediente other = (RLLancheIngrediente) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

}
