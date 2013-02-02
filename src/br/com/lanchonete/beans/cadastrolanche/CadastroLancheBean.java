package br.com.lanchonete.beans.cadastrolanche;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.lanchonete.model.Lanche;
import br.com.lanchonete.model.Usuario;
import br.com.lanchonete.service.LancheService;

public class CadastroLancheBean {

    private HttpSession sessao;
    private HttpServletRequest request;
    private Usuario usuario;

    private Lanche lanche;
    private List<Lanche> listaLanche;
    
    private int page;
    
    private LancheService lancheService;
   

    public CadastroLancheBean() {

	verificaLogin();
	lanche = new Lanche();
	listaLanche = new ArrayList<Lanche>();
	lancheService = new LancheService();
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
    
    public void addLanche(ActionEvent evento){
	
    }
    private void preencheLista(){
	listaLanche = lancheService.buscarLista();
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public Lanche getLanche() {
	return lanche;
    }

    public void setLanche(Lanche lanche) {
	this.lanche = lanche;
    }

    public List<Lanche> getListaLanche() {
	return listaLanche;
    }

    public void setListaLanche(List<Lanche> listaLanche) {
	this.listaLanche = listaLanche;
    }

    public int getPage() {
	return page;
    }

    public void setPage(int page) {
	this.page = page;
    }
}
