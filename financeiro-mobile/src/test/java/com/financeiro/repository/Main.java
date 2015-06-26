package com.financeiro.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.financeiro.model.Conta;
import com.financeiro.model.Usuario;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financeiroMobilePU");
		EntityManager em = emf.createEntityManager();
		
		/*String jpql = "select c from Conta c where c.usuario.codigo = :codigo";
		
		List<Conta> lista = em.createQuery(jpql).setParameter("codigo", 2L).getResultList(); 
		
		for (Conta conta : lista) {
			System.out.println(conta.getDescricao());
			System.out.println(conta.getValor());*/
		
		Usuario usuario = new Usuario();
		
		Conta conta = new Conta();
		conta.setDescricao("bolo");
		conta.setValor(new BigDecimal("45"));
		conta.setUsuario(usuario);
		
		em.getTransaction().begin();;
		em.persist(conta);
		em.getTransaction().commit();
		}
	}

