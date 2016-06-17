package com.springTutorialCadaDoCodigo.model;

import java.math.BigDecimal;

public class DadosPagamento {
	
	// Atributo
	private BigDecimal value;
	
	// Construtor padrao
	public DadosPagamento() {}

	// Construtor
	public DadosPagamento(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}
	
}
