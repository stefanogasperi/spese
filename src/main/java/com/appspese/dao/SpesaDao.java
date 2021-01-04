package com.appspese.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.appspese.model.Spesa;

public class SpesaDao {

	@PersistenceContext
	private EntityManager em;
	

	public Spesa merge(Spesa s) {
		return em.merge(s);
	}
	
	public void persist(Spesa s) {
		em.persist(s);
		em.refresh(s);
	}

	public Spesa findById(Long id) {
		return em.find(Spesa.class, id);
	}
	
	public List<Spesa> findAll() {
		return em.createNamedQuery(Spesa.FIND_ALL, Spesa.class).getResultList();
	}

}
