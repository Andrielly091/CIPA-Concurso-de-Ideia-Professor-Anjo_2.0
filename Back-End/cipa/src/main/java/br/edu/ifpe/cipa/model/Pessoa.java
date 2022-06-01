package br.edu.ifpe.cipa.model;

public class Pessoa {
	
	private int id;
	private String nome;
	private String email;
	private String tipo;
	
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
