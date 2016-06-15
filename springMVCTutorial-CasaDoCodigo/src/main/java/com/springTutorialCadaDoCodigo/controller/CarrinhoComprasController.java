package com.springTutorialCadaDoCodigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springTutorialCadaDoCodigo.dao.ProdutoDAO;
import com.springTutorialCadaDoCodigo.enuns.TipoProduto;
import com.springTutorialCadaDoCodigo.model.CarrinhoDeCompra;
import com.springTutorialCadaDoCodigo.model.ItemCompra;
import com.springTutorialCadaDoCodigo.model.Produto;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoComprasController {
	
	@Autowired
	ProdutoDAO produtoDAO;
	
	@Autowired
	CarrinhoDeCompra carrinhoDeCompra;
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView adicionarProdutoNoCarrinho(Integer idProduto, TipoProduto tipo) {
		
		ItemCompra item = criarItem(idProduto, tipo);
		
		carrinhoDeCompra.adicionarItem(item);
		
		return new ModelAndView("redirect:/carrinho/itens");
	}
	
	@RequestMapping(value = "/itens", method = RequestMethod.GET)
	public ModelAndView produtosAdicionadosNoCarrinho() {

		ModelAndView model = new ModelAndView("itens-carrinho");

		return model;
	}
	
	private ItemCompra criarItem(Integer idProduto, TipoProduto tipo) {
		Produto produto = produtoDAO.buscar(idProduto);
		ItemCompra item = new ItemCompra(produto, tipo);
		
		return item;
	}

}
