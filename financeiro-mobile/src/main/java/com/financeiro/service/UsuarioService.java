package com.financeiro.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.financeiro.model.Usuario;
import com.financeiro.repository.UsuarioRepository;
import com.financeiro.util.Transacional;

public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	public Usuario carregar(Long codigo){
		return this.usuarioRepository.buscarCodigo(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioRepository.buscarPorLogin(login);
	}
	
	@Transacional
	public void salvar(Usuario usuario){
		this.usuarioRepository.adicionar(usuario);
	}
	
	@Transacional
	public void excluir(Usuario usuario){
		this.usuarioRepository.remover(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioRepository.listarTodos();
	}
	
}
