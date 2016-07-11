package com.springTutorial.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springTutorial.model.UploadFile;

@Repository
public class UploadFileDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(UploadFile uploadFile) {
		em.persist(uploadFile);
	}
	
	public UploadFile buscar(Integer id){
		return em.find(UploadFile.class, id);
	}

}
