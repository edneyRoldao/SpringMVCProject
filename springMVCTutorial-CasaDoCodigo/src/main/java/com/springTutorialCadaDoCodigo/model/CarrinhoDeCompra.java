package com.springTutorialCadaDoCodigo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoDeCompra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
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
