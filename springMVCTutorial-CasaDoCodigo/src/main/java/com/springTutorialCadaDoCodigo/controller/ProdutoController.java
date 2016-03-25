package com.springTutorialCadaDoCodigo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springTutorialCadaDoCodigo.dao.ProdutoDAO;
import com.springTutorialCadaDoCodigo.enuns.TipoProduto;
import com.springTutorialCadaDoCodigo.model.Produto;

@Controller
@Transactional
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoDAO produtoDAO;
	
	
	@RequestMapping("/cadastro")
	public ModelAndView callForm() {
		ModelAndView model = new ModelAndView("cadastro-produto");
		model.addObject("tipos", TipoProduto.values());
		
		return model;
	}

	
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	public ModelAndView cadastrar(Produto produto, RedirectAttributes redirect) {
		
		produtoDAO.cadastrar(produto);
		redirect.addFlashAttribute("sucesso", "Produto cadastrado com sucesso !");
		
		// Aqui estamos realizando um Always redirect after post
		return new ModelAndView("redirect:lista");
	}
	
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView listarProdutos() {
		
		ModelAndView model = new ModelAndView("lista-produto");
		model.addObject("produtos", produtoDAO.listarTodos());
		
		return model;
	}
	
}
