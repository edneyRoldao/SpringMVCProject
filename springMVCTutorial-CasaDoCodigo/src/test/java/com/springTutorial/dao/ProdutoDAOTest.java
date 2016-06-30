package com.springTutorial.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springTutorial.builder.ProdutoBuilder;
import com.springTutorial.config.ConfigJPATest;
import com.springTutorial.enuns.TipoProduto;
import com.springTutorial.model.Produto;
import com.springTutorial.springConfig.ConfigJPADesenvolvimento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProdutoDAO.class, ConfigJPADesenvolvimento.class, ConfigJPATest.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {

	@Autowired
	private ProdutoDAO produtoDAO;

	@Test
	@Transactional
	public void deveSomarOsPrecosPorTipo() {
		
		List<Produto> prodImpressos = ProdutoBuilder.novoProduto(TipoProduto.IMPRESSO, BigDecimal.TEN).mais(4).buildAll();
		prodImpressos.stream().forEach(produtoDAO::cadastrar);

		List<Produto> ebooks = ProdutoBuilder.novoProduto(TipoProduto.EBOOK, BigDecimal.TEN).mais(4).buildAll();
		ebooks.stream().forEach(produtoDAO::cadastrar);

		BigDecimal valor = produtoDAO.somarPrecosPorTipo(TipoProduto.IMPRESSO);
		Assert.assertEquals(new BigDecimal(50).setScale(2), valor);		
		
	}
	
}