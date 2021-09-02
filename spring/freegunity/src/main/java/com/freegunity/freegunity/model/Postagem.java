package com.freegunity.freegunity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // INFORMA QUE A MODEL É UMA ENTIDADE E QUE ELA VIRARÁ UMA TABELA NO BD
@Table(name= "tb_postagem") // DEFINE O NOME DA TABELA NO BD
public class Postagem {
	// ATRIBUTOS
	@Id // DEFINE A CHAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // INSERE AUTO-INCREMENTO
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP) //
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@NotBlank // NÃO ACEITA VALORES NULOS OU VAZIO
	@Size(min = 5, max = 255) // DEFINE A QTDD MIN E MAX DE CARACTERES
	private String texto;
	
	@NotBlank // NÃO ACEITA VALORES NULOS OU VAZIO
	@Size(min = 5, max = 55) // DEFINE A QTDD MIN E MAX DE CARACTERES
	private String img;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
