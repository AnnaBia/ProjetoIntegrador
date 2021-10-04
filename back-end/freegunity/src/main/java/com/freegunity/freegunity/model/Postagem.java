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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // INFORMA QUE A MODEL É UMA ENTIDADE E QUE ELA VIRARÁ UMA TABELA NO BD
@Table(name = "tb_postagem") // DEFINE O NOME DA TABELA NO BD
public class Postagem {

	// ATRIBUTOS
	@Id // DEFINE A CHAVE PRIMARIA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // INSERE AUTO-INCREMENTO
	private long id;

	@Temporal(TemporalType.TIMESTAMP) // ATRIBUTO DE DATA
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@NotBlank // NÃO ACEITA VALORES NULOS OU VAZIO
	@Size(min = 5, max = 255) // DEFINE A QTDD MIN E MAX DE CARACTERES
	private String texto;

	@NotBlank // NÃO ACEITA VALORES NULOS OU VAZIO
	@Min(0)
	private String imagem;

	// RELACIONAMENTOS DE TABELAS
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	// GETTERS AND SETTERS
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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
