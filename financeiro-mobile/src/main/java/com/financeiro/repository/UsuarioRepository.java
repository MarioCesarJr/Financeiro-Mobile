package com.financeiro.repository;

import java.io.Serializable;

import org.hibernate.Query;

import com.financeiro.model.Usuario;

public class UsuarioRepository extends HibernateGeneric<Usuario, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Usuario buscarPorLogin(String login){
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = (Query) this.getEntityManager().createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

}
