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
	
	@PostConstruct
	public void init(){
		ContaRepository repository = new ContaRepository();
		this.lista = repository.listarTodos();
	}

	public void salvar() {
		ContaService service = new ContaService();
		service.salvar(this.conta);
		conta = new Conta();
		init();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Conta> getLista() {
		return lista;
	}

}
