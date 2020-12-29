package com.appspese.service;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import com.appspese.dao.SpesaDao;
import com.appspese.dao.UtenteDao;
import com.appspese.dto.Spesa;
import com.appspese.dto.SpesaMapper;
import com.appspese.exceptions.SpeseRestException;
import com.appspese.model.Utente;

@Transactional
public class SpesaService {
	
	@Inject
	private SpesaDao speseDao;
	
	@Inject
	private UtenteDao utenteDao;
	
	@Inject
	private SpesaMapper spesaMapper;

	public Spesa addSpesa(Spesa spesaDto) {
		List<Utente> utenteList = utenteDao.findByNome(spesaDto.getChi());
		if (utenteList.isEmpty()) {
			throw new SpeseRestException("Utente non presente", Response.Status.BAD_REQUEST);
		}
		com.appspese.model.Spesa spesaNew = spesaMapper.spesaDtoToSpesa(spesaDto);
		spesaNew.setChi(utenteList.get(0));
		speseDao.persist(spesaNew);
		Spesa spesaOut = spesaMapper.spesaToSpesaDto(spesaNew);
		
		return spesaOut;
	}
	
	public Spesa findById(Long id) {
		return spesaMapper.spesaToSpesaDto(speseDao.findById(id));
	}
	
	public List<Spesa> findAll() {
		List<com.appspese.model.Spesa> sl = speseDao.findAll();
		return sl.stream().map((it)->{
			return spesaMapper.spesaToSpesaDto(it);
		}).collect(Collectors.toList());
	}

}
