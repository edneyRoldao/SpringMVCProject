package com.springTutorial.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Como o banco de dados em produção é o postgres, precisamos retirar a anotação @Lob do atributo data
 * 
 * @author Edney Roldao
 *
 */
@Entity
public class UploadFile {
	
	// Atributos
	@Id
	@GeneratedValue
	private Integer id;
	
	private String fileName;
	
	@Lob
	@Basic
	private byte[] data;

	
	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
