package com.financeiro.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.financeiro.model.Usuario;
import com.financeiro.repository.UsuarioRepository;

@ManagedBean
@SessionScoped
public class ContextoBean {

	private Usuario usuarioLogado = null;
	
	public Usuario getUsuarioLogado(){
	
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		
		if(this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())){
			if(login != null){
				UsuarioRepository repository = new UsuarioRepository();
				this.usuarioLogado = repository.buscarPorLogin(login);
		
			}
		}
		
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
