package com.financeiro.service;

import java.io.Serializable;

import com.financeiro.model.Conta;
import com.financeiro.repository.ContaRepository;

public class ContaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void salvar(Conta conta){
		ContaRepository repository = new ContaRepository();
		repository.adicionar(conta);
	}
	
	public void excluir(Conta conta){
		ContaRepository repository = new ContaRepository();
		repository.excluir(conta);
 	}

}
