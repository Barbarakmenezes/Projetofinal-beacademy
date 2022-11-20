package com.beacademy.beacademy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "postagem") 
public class Postagem {
	
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)    // No banco de dados ele vai se transformar em uma chave primária
	private Long id;
	
	
	@NotNull
	@Size (min = 5, max = 100)    // essas 2 vão dizer que meu texto não pode ser nulo e nem passar de 100caracteres
	private String titulo;
	
	@NotNull
	@Size (min = 5, max = 500)
	private String texto;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;

}
