package com.springTutorial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;

import com.springTutorial.enuns.TipoProduto;

public class ItemCompra implements Serializable{

	private static final long serialVersionUID = 1L;

	//Atributos
	private Produto produto;
	private TipoProduto tipoProduto;
	private Integer idProduto;

	//Inicialização do objeto
	public static ItemCompra inicializarItem() {
		Produto produto = new Produto();
		Preco preco = new Preco();
		TipoProduto tipo = TipoProduto.COMBO;
		
		preco.setTipoProduto(tipo);
		preco.setValor(BigDecimal.ZERO);
		produto.setPrecos(Arrays.asList(preco));
		
		return new ItemCompra(produto, tipo);
	}
	
	//Métodos auxiliares que calculam os valores dos itens
	public BigDecimal getPreco() {
		//Verificar expressão lambda na classe produto
		return produto.ForPreco(this.tipoProduto);
	}
	public BigDecimal getTotal(Integer quantidade) {
		return getPreco().multiply(new BigDecimal(quantidade));
	}
	
	//Construtor
	public ItemCompra(Produto prod, TipoProduto tipo) {
		produto = prod;
		tipoProduto  = tipo;
		idProduto = prod.getId();
	}

	//Getters
	public Produto getProduto() {
		return produto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	// Hash and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result + ((tipoProduto == null) ? 0 : tipoProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompra other = (ItemCompra) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (tipoProduto != other.tipoProduto)
			return false;
		return true;
	}

}
