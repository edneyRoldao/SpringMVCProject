package com.springTutorialCadaDoCodigo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import com.springTutorialCadaDoCodigo.model.CarrinhoDeCompra;
import com.springTutorialCadaDoCodigo.service.IntegrandoComPagamento;

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

}
