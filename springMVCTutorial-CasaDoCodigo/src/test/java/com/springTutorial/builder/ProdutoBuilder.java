package com.springTutorial.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.springTutorial.enuns.TipoProduto;
import com.springTutorial.model.Preco;
import com.springTutorial.model.Produto;

public class ProdutoBuilder {

	List<Produto> produtos = new ArrayList<>();
	
	
	// Construtor
	public ProdutoBuilder(Produto produto) {
		produtos.add(produto);
	}
	
	private static Produto criar(String nome, TipoProduto tipo, BigDecimal valor) {
		Produto prod = new Produto();
		prod.setTitulo(nome);
		prod.setDataLancamento(Calendar.getInstance());
		prod.setPaginas(150);
		prod.setDescricao("teste de criado de produto");
		Preco p = new Preco();
		p.setTipoProduto(tipo);
		p.setValor(valor);
		prod.getPrecos().add(p);
		
		return prod;
	}
	
	public static ProdutoBuilder novoProduto(TipoProduto tipo, BigDecimal valor) {
		Produto prod = criar("Livro 01", TipoProduto.COMBO, BigDecimal.TEN);
		return new ProdutoBuilder(prod);
	}
	
	public ProdutoBuilder mais(int numero) {
		Produto base = produtos.get(0);
		Preco p = base.getPrecos().get(0);
		
		for(int i = 0; i < numero; i++) {
			produtos.add(criar("livro " + i, p.getTipoProduto(), p.getValor()));
		}
		
		return this;
	}
	
	public Produto buildOne() {
		return produtos.get(0);
	}
	
	public List<Produto> buildAll() {
		return produtos;
	}
	
}
