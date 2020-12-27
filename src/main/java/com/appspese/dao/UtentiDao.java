package com.appspese.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.appspese.model.Utenti;

public class UtentiDao {

	@PersistenceContext
	private EntityManager em;
	
	public Utenti merge(Utenti u) {
		return em.merge(u);
	}
	
	public void persist(Utenti u) {
		em.persist(u);
	}

	public Utenti findById(Long id) {
		return em.find(Utenti.class, id);
	}

	public List<Utenti> findAll() {
		return em.createNamedQuery("Utenti.findAll",Utenti.class).getResultList();
	}
}
