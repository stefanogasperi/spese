package com.appspese.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.appspese.model.Email;

public class EmailDAO {

	@PersistenceContext
	EntityManager em;
	
	public void persist(Email s) {
		em.persist(s);
		em.refresh(s);
	}
	
	public Email findById(Long id) {
		return em.find(Email.class, id);
	}
	
	public List<Email> findAll() {
		return em.createNamedQuery(Email.FIND_ALL, Email.class).getResultList();
	}
	
	public List<Email> getByPwdCQ(String pwd) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Email> q = cb.createQuery(Email.class);
		Root<Email> e = q.from(Email.class);
		ParameterExpression<String> ppwd = cb.parameter(String.class);		
		q
		.select(e)
		.where(cb.equal(e.get("password"), ppwd));
		
		TypedQuery<Email> tq = em.createQuery(q);
		tq.setParameter(ppwd, pwd);
		return tq.getResultList();
	}
}
