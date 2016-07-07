package com.springTutorial.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.springTutorial.enums.UserData;
import com.springTutorial.model.CarrinhoDeCompra;
import com.springTutorial.security.Usuario;
import com.springTutorial.service.IntegrandoComPagamento;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private CarrinhoDeCompra carrinho;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MailSender mailer;
	
	@RequestMapping(value="/finaliza", method = RequestMethod.POST)
	public DeferredResult<String> finalizaPagamento(@AuthenticationPrincipal Usuario user) {

		BigDecimal total = carrinho.getTotal();
		DeferredResult<String> result = new DeferredResult<>();
		IntegrandoComPagamento integrando = new IntegrandoComPagamento(result, total, restTemplate);
		
		// Enviando email.
		enviarEmailNovaCompra(user);
		
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

	private void enviarEmailNovaCompra(Usuario user) {
		SimpleMailMessage mail = new SimpleMailMessage();
		
		// Email de origem
		mail.setFrom(UserData.EMAIL.value);
		mail.setTo(user.getLogin());
		mail.setSubject("Nova compra");
		mail.setText("Compra efetuada");
		mailer.send(mail);
	}
	
}
