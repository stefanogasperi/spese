package com.appspese.dto;

import com.appspese.model.Utente;

public class UtenteMapper {
	
	public Utente utenteDtoToUtente(com.appspese.dto.Utente utenteDto) {
		Utente utente = new Utente();
		utente.setNome(utenteDto.getNome());
		return utente;
	}

	public com.appspese.dto.Utente utenteDtoToUtente(Utente utente) {
		return new com.appspese.dto.Utente(utente.getNome());
	}

}
