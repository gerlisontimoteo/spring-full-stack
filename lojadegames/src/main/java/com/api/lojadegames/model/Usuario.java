package com.api.lojadegames.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.UniqueConstraint;

@Entity
@Table
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=3, max=70)
	private String nome;
	
	@Email
	private String email;
	
	@NotNull
	@Size(min=6, max=25)
	private String senha;
	
	//@ManyToMany(mappedBy = "usuario")
	@ManyToMany
	@JoinTable(name="jogosDoUsuário",
	uniqueConstraints = @UniqueConstraint(columnNames = { "id_usuario", "id_jogo" }),
	joinColumns = @JoinColumn(name = "id_jogo" ),
	        inverseJoinColumns = @JoinColumn(name = "id_usuario")
	    )
	private List<Jogo> jogo;

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Jogo> getJogo() {
		return jogo;
	}

	public void setJogo(List<Jogo> jogo) {
		this.jogo = jogo;
	}


	
}
