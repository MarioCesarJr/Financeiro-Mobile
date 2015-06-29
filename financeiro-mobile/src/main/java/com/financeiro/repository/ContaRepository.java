package com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.financeiro.model.Conta;

public class ContaRepository extends HibernateGeneric<Conta, Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<Conta> listarConta(){
	
		Session session = getEntityManager().unwrap(Session.class);
		Criteria criteria = session.createCriteria(Conta.class);
		/*criteria.createAlias("usuario", "u");
		criteria.add(Restrictions.eq("usuario", usuario));*/
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> listarContaUsuario(Long codigo){
		String jpql = "select c from Conta c where c.usuario.codigo = :codigo";
		return getEntityManager().createQuery(jpql).setParameter("codigo", codigo).getResultList();
		 
	}
	
	public void excluir(Conta conta) {
		conta = buscarCodigo(conta.getCodigo());
		
		try {
			getEntityManager().remove(conta);
			getEntityManager().flush();
		} catch (PersistenceException e) {
			e.getMessage();
		}
	}
}
