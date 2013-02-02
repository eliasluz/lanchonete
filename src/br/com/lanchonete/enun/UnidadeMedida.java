package br.com.lanchonete.enun;

public enum UnidadeMedida {
	
	UNIDADE("UN","Unidade"),
	KILO_GRAMA("KG","Kilo Grama");
	
	private String codigo;
	private String valor;
	
	private UnidadeMedida(String codigo, String valor){
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
