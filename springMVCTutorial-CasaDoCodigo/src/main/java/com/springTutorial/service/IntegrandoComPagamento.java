package com.springTutorial.service;

import java.math.BigDecimal;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import com.springTutorial.model.DadosPagamento;

public class IntegrandoComPagamento implements Runnable {
	
	private static final String URL_PAGTO = "http://book-payment.herokuapp.com/payment";
	
	private DeferredResult<String> result;
	private BigDecimal value;
	private RestTemplate restTemplate;
	
	
	public IntegrandoComPagamento(DeferredResult<String> result, BigDecimal value, RestTemplate restTemplate) {
		super();
		this.result = result;
		this.value = value;
		this.restTemplate = restTemplate;
	}
	

	@Override
	@SuppressWarnings("unused")
	public void run() {
		try {
			String response = restTemplate.postForObject(URL_PAGTO, new DadosPagamento(value), String.class);
			result.setResult("redirect:/pagamento/success");
			
		} catch (HttpClientErrorException e) {
			result.setResult("redirect:/pagamento/error");
		}
	}

}
