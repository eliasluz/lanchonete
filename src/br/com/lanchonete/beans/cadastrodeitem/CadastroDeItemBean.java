package br.com.lanchonete.beans.cadastrodeitem;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.lanchonete.enun.UnidadeMedida;
import br.com.lanchonete.model.Ingrediente;
import br.com.lanchonete.model.Usuario;
import br.com.lanchonete.service.IngredienteService;

public class CadastroDeItemBean {

    private HttpSession sessao;
    private HttpServletRequest request;

    private Usuario usuario;
    private Ingrediente ingrediente;
    private UnidadeMedida unidade;
    private List<UnidadeMedida> listaUnidadeMedida;
    private List<SelectItem> listaItem;

    private List<Ingrediente> listaIngrediente;

    private IngredienteService ingredienteService;
    
    private int page = 1;
    
    

    public CadastroDeItemBean() {
	ingrediente = new Ingrediente();
	verificaLogin();
	ingredienteService = new IngredienteService();
	preencheLista();
    }

    private void verificaLogin() {
	FacesContext context = FacesContext.getCurrentInstance();
	ExternalContext ec = context.getExternalContext();
	Object o = ec.getRequest();
	request = (HttpServletRequest) o;
	sessao = request.getSession();
	setUsuario((Usuario) sessao.getAttribute("usuario"));
    }

    public List<SelectItem> getListaItem() {
	listaUnidadeMedida = new ArrayList<UnidadeMedida>();
	listaItem = new ArrayList<SelectItem>();
	UnidadeMedida[] vetor = UnidadeMedida.values();

	for (int i = 0; i < vetor.length; i++) {
	    listaUnidadeMedida.add(vetor[i]);
	}
	for (UnidadeMedida u : listaUnidadeMedida) {
	    listaItem.add(new SelectItem(u, u.getValor()));
	}

	return listaItem;
    }

    public void addIngrediente(ActionEvent evento) {
	ingrediente.setUnidade(unidade.getCodigo());
	ingrediente.setUsuario(usuario.getNome());
	ingredienteService.salvar(ingrediente);
	ingrediente = new Ingrediente();
	preencheLista();
    }
    
    public void remove(){
	
    }

    private void preencheLista() {
	listaIngrediente = ingredienteService.buscarLista();
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public Ingrediente getIngrediente() {
	return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
	this.ingrediente = ingrediente;
    }

    public List<Ingrediente> getListaIngrediente() {
	return listaIngrediente;
    }

    public void setListaIngrediente(List<Ingrediente> listaIngrediente) {
	this.listaIngrediente = listaIngrediente;
    }

    public UnidadeMedida getUnidade() {
	return unidade;
    }

    public void setUnidade(UnidadeMedida unidade) {
	this.unidade = unidade;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }
}
