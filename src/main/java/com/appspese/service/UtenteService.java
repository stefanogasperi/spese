package com.appspese.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.appspese.dao.UtenteDao;
import com.appspese.dto.Utente;
import com.appspese.dto.UtenteMapper;
import com.appspese.exceptions.SpeseRestException;

@Transactional
public class UtenteService {

	@Inject
	private UtenteDao utenteDao;
	
	@Inject
	private UtenteMapper utenteMapper;
	
	public Utente findById(Long id) {
		return utenteMapper.utenteToUtenteDto(utenteDao.findById(id));
	}
	
	public List<Utente> findByNome(String nome) {
		return utenteDao.findByNome(nome).stream().map((it)->{
			return utenteMapper.utenteToUtenteDto(it);
		}).collect(Collectors.toList());
	}

	public List<Utente> findAll() {
		List<com.appspese.model.Utente> ul = utenteDao.findAll();
		return ul.stream().map((it)->{
			return utenteMapper.utenteToUtenteDto(it);
		}
		).collect(Collectors.toList());
	}
	
	public Utente add(Utente utenteDto) {
		
		List<com.appspese.model.Utente> utenteList = utenteDao.findByNome(utenteDto.getNome());
		if (!utenteList.isEmpty()) {
			throw new SpeseRestException("Utente gia presente", Response.Status.BAD_REQUEST);
		}
		com.appspese.model.Utente utenteNew = utenteMapper.utenteDtoToUtente(utenteDto);		
		utenteDao.persist(utenteNew);
		return utenteDto;
	}
}
