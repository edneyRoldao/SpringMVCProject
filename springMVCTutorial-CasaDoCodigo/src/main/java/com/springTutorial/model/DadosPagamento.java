package com.springTutorial.model;

import java.math.BigDecimal;

/**
 * Esta classe sera convertida uma objeto JSON que sera enviado para o servico rest de pagamento.
 * @author edneyroldao
 *
 */
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