package com.springTutorial.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_UPLOAD")
public class UploadFile {
	
	// Atributos
	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private Integer id;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "FILE_DATA", columnDefinition = "mediumblob")
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
