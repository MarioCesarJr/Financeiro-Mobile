package com.financeiro.repository;

import org.junit.Before;
import org.junit.Test;

import com.financeiro.model.Usuario;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;
import static org.junit.Assert.assertEquals;

public class UsuarioRepositoryTest {

	private JIntegrity helper = new JIntegrity();

	private UsuarioRepository usuarioRepository;
	
	@Before
	public void init() {
		helper.cleanAndInsert();
	    
		this.usuarioRepository = new UsuarioRepository();
		this.usuarioRepository.setManager(JPAHelper.currentEntityManager());
	}
	
	@Test
	public void buscarUsuarioPeloCodigo(){
		Usuario usuario = usuarioRepository.buscarCodigo(1L);
		assertEquals(1L, usuario.getCodigo().longValue());
		assertEquals("john snow", usuario.getNome());
		assertEquals("johnsnow@gmail.com", usuario.getEmail());
		assertEquals("snow", usuario.getLogin());
		assertEquals("2334343", usuario.getSenha());
	}
}
