package com.financeiro.repository;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.financeiro.model.Conta;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class ContaRepositoryTest {

	private JIntegrity helper = new JIntegrity();
	
	private ContaRepository contaRepository;
	
	@Before
	public void init() {
		helper.cleanAndInsert();
	    
		this.contaRepository = new ContaRepository();
		this.contaRepository.setManager(JPAHelper.currentEntityManager());
	}
	
	@Test
	public void listarContaUsuario(){
		List<Conta> lista = contaRepository.listarContaUsuario(2L);
		
		for (Conta conta : lista) {
			System.out.println(conta.getDescricao());
			System.out.println(conta.getValor());
		}
	}
}
