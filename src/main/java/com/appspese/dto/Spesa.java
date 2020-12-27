package com.appspese.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;

public class Spesa {

	private Long id;

	private String chi;

	private String titolo;

	private BigDecimal importo;

	private String descrizione;
	
	@JsonbDateFormat("yyyy-MM-dd")
	private LocalDate data;
}
