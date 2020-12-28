package com.appspese.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import com.appspese.model.Utente;

public class UtenteDao {

	@PersistenceContext
	private EntityManager em;
	
	public Utente merge(Utente u) {
		return em.merge(u);
	}
	
	public void persist(Utente u) {
		em.persist(u);
	}

	public Utente findById(Long id) {
		return em.find(Utente.class, id);
	}

	public List<Utente> findByNome(String nome) {
		return em.createNamedQuery(Utente.FIND_BY_NOME, Utente.class).setParameter("nome", nome).getResultList();
	}

	public List<Utente> findAll() {
		return em.createNamedQuery("Utenti.findAll",Utente.class).getResultList();
	}
}
