package com.financeiro.test;

import javax.persistence.Persistence;

import org.junit.Test;

public class TestConexao {

	@Test
	public void deveConectarNoBancoGerarTabelas(){
		Persistence.createEntityManagerFactory("financeiroMobilePU");
		System.out.println("CONECTOU !");
	}
}
