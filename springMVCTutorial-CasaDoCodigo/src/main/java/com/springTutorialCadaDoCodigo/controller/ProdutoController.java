package com.springTutorialCadaDoCodigo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springTutorialCadaDoCodigo.dao.ProdutoDAO;
import com.springTutorialCadaDoCodigo.model.Produto;

@Controller
@Transactional
public class ProdutoController {
	
	@Autowired
	ProdutoDAO produtoDAO;
	
	@RequestMapping("/produto/cadastro")
	public String callForm() {
		return "cadastro-produto";
	}

	@RequestMapping("/produtos")
	public String cadastrar(Produto produto) {
		
		System.out.println("Cadastrando livro..." + produto.toString());
		produtoDAO.cadastrar(produto);
		
		return "lista-produtos";
	}
	
}
