package com.financeiro.repository;

import java.io.Serializable;

import javax.persistence.Query;

import com.financeiro.model.Usuario;

public class UsuarioRepository extends HibernateGeneric<Usuario, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Usuario buscarPorLogin(String login) {
		Query query = this.getEntityManager().createQuery(
				"From Usuario u Where u.login = :login", Usuario.class);
		query.setParameter("login", login);
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception exception) {
			return null;
		}
	}


}
