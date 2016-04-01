package com.springTutorialCadaDoCodigo.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

	/*	
	 	O código abaixo foi comentado pois não iremos usar validadores customizados. 
	 	Sua criação foi motivada para mostrar como podemos criar tais validadores com o Spring MVC.
	 	Perceba que agora vamos utilizar a integração que o spring possuí com a especificação da beanValidation
	 	que é implementada pelo pessoal do hibernate.
	 
		@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.setValidator(new ProdutoValidation());
		}
	*/
	
	@RequestMapping("/cadastro")
	public ModelAndView callForm(Produto produto) {
		ModelAndView model = new ModelAndView("cadastro-produto");
		model.addObject("tipos", TipoProduto.values());

		return model;
	}

	@RequestMapping(value = "/lista", method = RequestMethod.POST, name = "cadastroProduto")
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult bindResult, RedirectAttributes redirect) {

		if (bindResult.hasErrors())
			return callForm(produto);

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
