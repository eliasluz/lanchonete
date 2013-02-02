package br.com.lanchonete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.lanchonete.enun.UnidadeMedida;

public class UnidadeConverter implements Converter {

    public Object getAsObject(FacesContext contexto, UIComponent componente,
	    String valor) {

	UnidadeMedida u = UnidadeMedida.valueOf(valor.toUpperCase());
	return u;
    }

    public String getAsString(FacesContext contexto, UIComponent componente,
	    Object valor) {

	UnidadeMedida u = (UnidadeMedida) valor;
	return u.toString();
    }

}
