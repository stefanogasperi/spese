package com.appspese.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.appspese.model.Spese;

@NamedQuery(name = "Spese.findAll", query = "select s from Spese s")
public class SpeseDao {

	@PersistenceContext
	private EntityManager em;
	

	public Spese merge(Spese s) {
		return em.merge(s);
	}
	
	public void persist(Spese s) {
		em.persist(s);
		em.refresh(s);
	}

	public Spese findById(Long id) {
		return em.find(Spese.class, id);
	}
	
	public List<Spese> findAll() {
		return em.createNamedQuery("Spese.findAll", Spese.class).getResultList();
	}

}
