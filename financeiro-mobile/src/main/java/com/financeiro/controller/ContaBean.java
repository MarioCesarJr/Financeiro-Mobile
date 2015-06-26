package com.financeiro.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.financeiro.model.Conta;
import com.financeiro.repository.ContaRepository;
import com.financeiro.service.ContaService;

@ManagedBean
@RequestScoped
public class ContaBean {

	private Conta conta = new Conta();
	
	private List<Conta> lista;
	
	private LoginUsuarioBean usuario;
	/*public ContaBean(){
        lista = new ArrayList<Conta>();
  }*/

	/*@PostConstruct
	public void init(){
		ContaRepository repository = new ContaRepository();
		this.lista = repository.listarContaUsuario(usuario.getIdUsuario());
	}*/
	
	public void salvar() {
		ContaService service = new ContaService();
		service.salvar(this.conta);
		this.conta = new Conta();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getLista() {
	/*	this.lista = new ArrayList<Conta>();
		if(this.lista == null){
			LoginUsuarioBean contextoBean = ContextoUtil.getContextoBean();
			ContaRepository repository = new ContaRepository();
			this.lista = repository.listarConta(contextoBean.getUsuarioLogado());
		}*/
		return this.lista;
	}
	
	public String contaUsuario(){
		return "/restrito/conta?faces-redirect=true";
	}

}
