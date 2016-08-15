package com.springTutorial.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.springTutorial.dao.UploadFileDAO;
import com.springTutorial.enums.TipoProduto;
import com.springTutorial.model.Produto;
import com.springTutorial.model.UploadFile;

@Controller
@Transactional
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private UploadFileDAO uploadFileDAO;

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
	public ModelAndView cadastrar(MultipartFile imgFile, @Valid Produto produto, BindingResult bindResult, RedirectAttributes redirect) throws IOException {
		
		if (bindResult.hasErrors())
			return callForm(produto);

		if(!imgFile.isEmpty()) {
			System.out.println("Saving file: " + imgFile.getOriginalFilename());

			UploadFile uploadFile = new UploadFile();
			uploadFile.setFileName(imgFile.getOriginalFilename());
			uploadFile.setData(imgFile.getBytes());
			
			uploadFileDAO.save(uploadFile);
			produto.setImagem(uploadFile);
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
	
	@RequestMapping("displayImage/{id}")
	public void showImage(@PathVariable("id") Integer itemId, HttpServletResponse response, HttpServletRequest request) throws IOException {
		UploadFile file = uploadFileDAO.buscar(itemId);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(file.getData());
		response.getOutputStream().close();
	}

}
