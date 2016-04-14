package com.springTutorialCadaDoCodigo.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CarrinhoDeCompra {
	
	private Map<ItemCompra, Integer> itens = new LinkedHashMap<>();
	
	public void adicionarItem(ItemCompra item) {
		itens.put(item, getQuantidade(item) + 1);
	}
	
	public Integer getQuantidade(ItemCompra item) {
		if(!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		return itens.get(item);
	}
	
	public Integer getQuantidade() {
		return itens.values().stream()
							  .reduce(0, (next, accumulator) -> next + accumulator);
	}
	
	public Collection<ItemCompra> getLista() {
		return itens.keySet();
	}
	
	public BigDecimal getTotal(ItemCompra item) {
		return item.getTotal(getQuantidade(item));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(ItemCompra item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}
	
	public void remove(ItemCompra item) {
		itens.remove(item);
	}
	
	public boolean isVazio() {
		return itens.isEmpty();
	}

}
