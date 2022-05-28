package br.edu.ifpe.email.novatentativa.model;

import lombok.Data;

@Data
public class User {
	
	
	private String nome;
	private String email;
	private String senha;
	/**
	 * @param nome
	 * @param email
	 */
	public User(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
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
	
	

}
