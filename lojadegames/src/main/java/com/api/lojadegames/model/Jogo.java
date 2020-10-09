package com.api.lojadegames.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	
	private float preco;
	
	private int classicacao; // idade minima para jogar
	
	@ManyToOne
	@JsonIgnoreProperties("jogo")
	private Categoria categoria;

	//@ManyToMany
	@ManyToMany
	@JoinTable(
	        name="jogosDoUsuário", 
	        uniqueConstraints = @UniqueConstraint(columnNames = { "id_usuario", "id_jogo" }),
	        joinColumns        = @JoinColumn(name = "id_usuario" ),
	        inverseJoinColumns = @JoinColumn(name = "id_jogo")
	    )
	private List<Usuario> usuario;
	
	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getClassicacao() {
		return classicacao;
	}

	public void setClassicacao(int classicacao) {
		this.classicacao = classicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
