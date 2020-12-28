package com.appspese.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;

public class Spesa {

	private String chi;

	private String titolo;

	private BigDecimal importo;

	private String descrizione;
	
	@JsonbDateFormat("yyyy-MM-dd")
	private LocalDate data;
	
	public Spesa(String chi, String titolo, BigDecimal importo, String descrizione, LocalDate data) {
		this.chi = chi;
		this.titolo = titolo;
		this.importo = importo;
		this.descrizione = descrizione;
		this.data = data;
	}
	
	public Spesa() {
		super();
	}

	public String getChi() {
		return chi;
	}

	public void setChi(String chi) {
		this.chi = chi;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public BigDecimal getImporto() {
		return importo;
	}

	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
