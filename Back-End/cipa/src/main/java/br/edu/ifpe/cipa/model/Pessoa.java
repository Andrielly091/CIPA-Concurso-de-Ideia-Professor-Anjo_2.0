package br.edu.ifpe.cipa.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Pessoa {
	private int id;
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "name")
	private String nome;
	@JsonInclude(Include.NON_NULL)
	@Email(message = "Informe um email valido")
	private String email;
	@Size(min = 8, max = 200, message = "About Me must be between 8 and 200 characters")
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "senha")
	private String senha;
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "tipo")
	private String tipo;
	@JsonInclude(Include.NON_DEFAULT)
	private boolean auth;

	public boolean isAuth() {
		return auth;
	}

	public void setAuth(boolean auth) {
		this.auth = auth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
