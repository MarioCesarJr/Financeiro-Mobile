package com.financeiro.service;

import java.io.Serializable;

import com.financeiro.model.Usuario;
import com.financeiro.repository.UsuarioRepository;

public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public void salvar(Usuario usuario){
		 UsuarioRepository usuarioRepository = new UsuarioRepository();
		 usuarioRepository.adicionar(usuario);
	}
	
	
}
