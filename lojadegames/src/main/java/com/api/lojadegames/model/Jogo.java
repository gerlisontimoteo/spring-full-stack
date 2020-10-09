package com.api.lojadegames.model;

public class Jogo {
	
	private long id;
	
	private String titulo;
	
	private float preco;
	
	private int classicacao; // idade minima para jogar
	
	private Categoria categoria;

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
