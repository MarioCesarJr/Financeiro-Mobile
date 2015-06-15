package com.financeiro.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.financeiro.model.Conta;
import com.financeiro.service.ContaService;

@ManagedBean
@RequestScoped
public class ContaBean {

	private Conta conta = new Conta();
	private List<Conta> lista = null;

	public void salvar() {
		ContaService service = new ContaService();
		service.salvar(this.conta);
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

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}
}
