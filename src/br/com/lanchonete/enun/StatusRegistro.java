package br.com.lanchonete.enun;

public enum StatusRegistro {
	
	ATIVO("S","Status Ativo"),
	INATIVO("N","Inativo");
	

	/**
	 * criando classe enum
	 */
	private String codigo;
	private String valor;
	
	private StatusRegistro(String codigo,String valor){
		this.codigo = codigo;
		this.valor = valor;
	}
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
