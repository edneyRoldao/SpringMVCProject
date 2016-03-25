package com.springTutorialCadaDoCodigo.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springTutorialCadaDoCodigo.model.Produto;

@Repository
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void cadastrar(Produto produto) {
		em.persist(produto);
	}

	public Object listarTodos() {
		return em.createQuery("select distinct(p) from Produto p join fetch p.precos", Produto.class).getResultList();
	}

}
