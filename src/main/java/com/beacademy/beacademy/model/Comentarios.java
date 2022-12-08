package com.beacademy.beacademy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comentarios")
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotNull(message = "O Atributo Nome é Obrigatório!")
	private String nome;
	
	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;
	
	
	@NotNull
	@Size (min = 5, max = 500)
	private String texto;
	

	

	@ManyToOne
	@JsonIgnoreProperties("comentarios")
	private Postagem postagem;


	@ManyToOne
	@JsonIgnoreProperties("comentarios")
	private Usuario usuario; 


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public String getTexto() {
		return texto;
	}




	public void setTexto(String texto) {
		this.texto = texto;
	}




	public Postagem getPostagem() {
		return postagem;
	}




	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
