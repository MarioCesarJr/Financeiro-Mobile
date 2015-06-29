package com.financeiro.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.financeiro.model.Conta;
import com.financeiro.model.Usuario;
import com.financeiro.repository.ContaRepository;
import com.financeiro.repository.UsuarioRepository;
import com.financeiro.service.ContaService;

@ManagedBean
@SessionScoped
public class LoginUsuarioBean {

	private Usuario usuarioLogado;
	private Usuario usuarioLogin;
	private List<Conta> lista = null;
	private Conta conta = new Conta();
	private Conta contaSelecionada;

	@PostConstruct
	public void init() {
		usuarioLogin = new Usuario();
	}

	public void salvar() {
		ContaService service = new ContaService();
		this.conta.setUsuario(usuarioLogado);
		service.salvar(this.conta);
		this.conta = new Conta();
        this.lista = null;
        this.getLista();
	}
	
	public void excluir(){
		ContaService service = new ContaService();
		service.excluir(contaSelecionada);
		this.lista = null;
		this.getLista();
	}

	public Long getIdUsuario() {
		return usuarioLogado.getCodigo();
	}

	public String getNomeUsuario() {
		return usuarioLogado.getNome();
	}

	public boolean isLogado() {
		return usuarioLogado != null;
	}

	public String login() {
		if (fazerLogin()) {
			return "/restrito/principal?faces-redirect=true";
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("senha ou usuário incorretos "));
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

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public List<Conta> getLista() {
		if (this.lista == null) {
			ContaRepository repository = new ContaRepository();
			this.lista = repository.listarContaUsuario(getIdUsuario());

		}
		return lista;
	}


	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Conta getContaSelecionada() {
		return contaSelecionada;
	}
	
	public void setContaSelecionada(Conta contaSelecionada) {
		this.contaSelecionada = contaSelecionada;
	}
}
