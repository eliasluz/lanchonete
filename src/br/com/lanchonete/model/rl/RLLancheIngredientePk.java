package br.com.lanchonete.model.rl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RLLancheIngredientePk implements Serializable {	
	

	private static final long serialVersionUID = -519198639542384944L;

	/**
	 * Criando o mapeamento das duas variaveis
	 */
	@Column(name="COD_LANCHE")
	private int codLanche;
	
	@Column(name="COD_INGREDIENTE")
	private int codIngrediente;

	/**
	 * Criando o get set e hashcode equal
	 */
	
	public int getCodLanche() {
		return codLanche;
	}

	public void setCodLanche(int codLanche) {
		this.codLanche = codLanche;
	}

	public int getCodIngrediente() {
		return codIngrediente;
	}

	public void setCodIngrediente(int codIngrediente) {
		this.codIngrediente = codIngrediente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codIngrediente;
		result = prime * result + codLanche;
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
		RLLancheIngredientePk other = (RLLancheIngredientePk) obj;
		if (codIngrediente != other.codIngrediente)
			return false;
		if (codLanche != other.codLanche)
			return false;
		return true;
	}
	

}
