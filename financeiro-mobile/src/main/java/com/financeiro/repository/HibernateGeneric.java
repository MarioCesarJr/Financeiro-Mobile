package com.financeiro.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class HibernateGeneric<T, ID extends Serializable> {

	@Inject
	private EntityManager manager;

	private Class<T> classeEntidade;

	@SuppressWarnings("unchecked")
	public HibernateGeneric() {
		this.classeEntidade = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T buscarCodigo(ID id) {
		return manager.find(classeEntidade, id);
	}

	public void adicionar(T entidade) {
		manager.merge(entidade);
	}

	public void remover(T entidade) {
		manager.remove(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<T> listarTodos() {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(classeEntidade);
		return criteria.list();
	}

	protected EntityManager getEntityManager() {
		return manager;
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	protected Session getSession() {
		return manager.unwrap(Session.class);
	}
}
