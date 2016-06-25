package com.springTutorial.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.springTutorial.model.CarrinhoDeCompra;
import com.springTutorial.service.IntegrandoComPagamento;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	CarrinhoDeCompra carrinho;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/finaliza", method = RequestMethod.POST)
	public DeferredResult<String> finalizaPagamento() {

		BigDecimal total = carrinho.getTotal();
		DeferredResult<String> result = new DeferredResult<>();
		IntegrandoComPagamento integrando = new IntegrandoComPagamento(result, total, restTemplate);
		
		Thread thread = new Thread(integrando);
		thread.start();
		return result;
	}
	
	@RequestMapping(value="/success", method= RequestMethod.GET)
	public ModelAndView finalizarCompra() {
		return new ModelAndView("compra-sucesso");
	}

	@RequestMapping(value="/error", method= RequestMethod.GET)
	public ModelAndView erroCompra() {
		return new ModelAndView("compra-erro");
	}

}
