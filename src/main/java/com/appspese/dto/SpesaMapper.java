package com.appspese.dto;

import javax.inject.Inject;

import com.appspese.model.Spesa;


public class SpesaMapper {
	
	public Spesa spesaDtoToSpesa(com.appspese.dto.Spesa spesaDto) {
		Spesa spesa = new Spesa();
		spesa.setData(spesaDto.getData());
		spesa.setDescrizione(spesaDto.getDescrizione());
		spesa.setImporto(spesaDto.getImporto());
		spesa.setTitolo(spesaDto.getTitolo());
		return spesa;
	}
	
	public com.appspese.dto.Spesa spesaToSpesaDto(Spesa spesaDto) {
		com.appspese.dto.Spesa spesa = new com.appspese.dto.Spesa(
				spesaDto.getChi().getNome(), spesaDto.getTitolo(), spesaDto.getImporto()
				,spesaDto.getDescrizione(), spesaDto.getData());
		return spesa;
	}
	
}
