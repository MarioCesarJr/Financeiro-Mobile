package com.financeiro.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.financeiro.model.Usuario;
import com.financeiro.service.UsuarioService;

@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	private String confirmarSenha;
	
	public String novo(){
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}
	
	public String salvar() {
        UsuarioService service = new UsuarioService();
        
        String senha = this.usuario.getSenha();
        
        if(!senha.equals(this.confirmarSenha)){
        	return null;
        }
		
        service.salvar(this.usuario);
        
        return "usuarioSucesso";
	

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
