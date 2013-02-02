package br.com.lanchonete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.lanchonete.enun.StatusRegistro;

@Entity
@Table(name = "TB_INGREDIENTE ")
@SequenceGenerator(name = "codigo", sequenceName = "SEQ_CODIGO_INGREDIENTE", allocationSize = 1)
public class Ingrediente {

    @Id
    @Column(name = "CODIGO")
    @GeneratedValue(generator = "codigo", strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QUANTIDADE")
    private int quantidade;

    @Column(name = "UNIDADE")
    private String unidade;

    @Column(name = "VALOR")
    private double valor;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "ST_REGISTRO")
    private String stRegistro = StatusRegistro.ATIVO.getCodigo();

    /**
     * criando get set hashcode equals
     * 
     * @return
     */

    public int getCodigo() {
	return codigo;
    }

    public void setCodigo(int codigo) {
	this.codigo = codigo;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public int getQuantidade() {
	return quantidade;
    }

    public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
    }

    public String getUnidade() {
	return unidade;
    }

    public void setUnidade(String unidade) {
	this.unidade = unidade;
    }

    public double getValor() {
	return valor;
    }

    public void setValor(double valor) {
	this.valor = valor;
    }

    public String getStRegistro() {
	return stRegistro;
    }

    public void setStRegistro(String stRegistro) {
	this.stRegistro = stRegistro;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(String usuario) {
	this.usuario = usuario;
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
	Ingrediente other = (Ingrediente) obj;
	if (codigo != other.codigo)
	    return false;
	return true;
    }

}