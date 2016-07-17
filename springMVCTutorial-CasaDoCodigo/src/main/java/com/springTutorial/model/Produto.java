package com.springTutorial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.springTutorial.enums.TipoProduto;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String titulo;

	private String subtitulo;

	@Lob
	@NotBlank
	private String descricao;

	@Min(30)
	private int paginas;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "esta campo é obrigatório, seu formato é dd/MM/yyyy")
	private Calendar dataLancamento;

	@ManyToOne	
	private UploadFile imagem;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Preco> precos = new ArrayList<>();
	
	
	//Método auxiliar
	public BigDecimal ForPreco(TipoProduto tipo) {
		return precos.stream()
					 .filter(preco -> preco.getTipoProduto().equals(tipo))
					 .findFirst().get().getValor();
	}
	

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public UploadFile getImagem() {
		return imagem;
	}

	public void setImagem(UploadFile imagem) {
		this.imagem = imagem;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

}
