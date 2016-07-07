package com.springTutorial.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springTutorial.dao.ProdutoDAO;
import com.springTutorial.enums.TipoProduto;
import com.springTutorial.model.Produto;
import com.springTutorial.util.FileSaver;

@Controller
@Transactional
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private FileSaver fileSaver;

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

	@CacheEvict(value="livros", allEntries=true)
	@RequestMapping(value = "/lista", method = RequestMethod.POST, name = "cadastroProduto")
	public ModelAndView cadastrar(MultipartFile resumo, @Valid Produto produto, BindingResult bindResult, RedirectAttributes redirect) {
		
		if (bindResult.hasErrors())
			return callForm(produto);

		if(!resumo.isEmpty()) {
			String path = saveFileUploaded(resumo);
			
			produto.setCaminhoResumo(path);
		}
		
		produtoDAO.cadastrar(produto);
		redirect.addFlashAttribute("sucesso", "Produto cadastrado com sucesso !");

		// Aqui estamos realizando um Always redirect after post
		return new ModelAndView("redirect:lista");
	}

	@Cacheable(value="livros")
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView listarProdutos() {

		ModelAndView model = new ModelAndView("lista-produto");
		model.addObject("produtos", produtoDAO.listarTodos());

		return model;
	}
	
	@RequestMapping("/detalhes/{id}")
	public ModelAndView detalhar(@PathVariable("id") int id) {
		
		ModelAndView model = new ModelAndView("detalhes-produto");
		
		Produto produto = produtoDAO.buscar(id);
	
		model.addObject("produto", produto);
		
		return model;
	}
	
	private String saveFileUploaded(MultipartFile resumo) {
		String webPath = "/" + fileSaver.write("resources/img", resumo);
		// path to retrieve the file and use from html or jps file <img src="${product.summaryPath}"/>
		return webPath;
	}

}
