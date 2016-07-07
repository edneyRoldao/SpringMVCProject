package com.springTutorial.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springTutorial.enums.TipoProduto;
import com.springTutorial.model.Produto;

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

	public Produto buscar(int id) {
		return em.find(Produto.class, id);
	}
	
	public BigDecimal somarPrecosPorTipo(TipoProduto tipo) {
		String consulta = "select sum(preco.valor) from Produto p join p.precos preco where preco.tipoProduto = :tipo";
		TypedQuery<BigDecimal> query = em.createQuery(consulta, BigDecimal.class);
		query.setParameter("tipo", tipo);
		
		return query.getSingleResult();
	}
	
}
