package com.springTutorialCadaDoCodigo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotBlank;

import com.springTutorialCadaDoCodigo.enuns.TipoProduto;

@Embeddable
public class Preco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(scale = 2)
	@NotBlank(message = "Valor informar o valor")
	private BigDecimal valor;

	private TipoProduto tipoProduto;

	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}
