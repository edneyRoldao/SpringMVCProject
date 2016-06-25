package com.springTutorial.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springTutorial.springConfig.JPAConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProdutoDAO.class, JPAConfig.class})
public class ProdutoDAOTest {

	@Test
	public void deveSomarOsPrecosPorTipo() {
		
	}
	
}
