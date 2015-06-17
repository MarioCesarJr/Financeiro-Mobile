package com.financeiro.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.financeiro.model.Usuario;
import com.financeiro.repository.UsuarioRepository;

@ManagedBean
@SessionScoped
public class LoginUsuarioBean {

	private Usuario usuarioLogado;
	private Usuario usuarioLogin;

	@PostConstruct
	public void init() {
		usuarioLogin = new Usuario();
	}

	public String getNomeUsuario() {
		return usuarioLogado.getNome();
	}

	public boolean isLogado() {
		return usuarioLogado != null;
	}

	public String login() {
		if (fazerLogin()) {
			return "/restrito/conta?faces-redirect=true";
		}
		
		return "";
	}

	private boolean fazerLogin() {
		UsuarioRepository dao = new UsuarioRepository();
		Usuario usuario = dao.buscarPorLogin(usuarioLogin.getLogin());
		if (usuario == null)
			return false;
		if (!usuario.getSenha().equals(usuarioLogin.getSenha()))
			return false;
		if (!usuario.getLogin().equalsIgnoreCase(usuarioLogin.getLogin()))
			return false;
		usuarioLogado = usuario;
		return true;
	}

	public String logout() {
		usuarioLogado = null;
		return "/publico/login?faces-redirect=true";
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
}
