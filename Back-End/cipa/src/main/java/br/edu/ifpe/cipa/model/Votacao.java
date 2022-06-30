package br.edu.ifpe.cipa.model;

import javax.validation.constraints.NotNull;

public class Votacao {
	@NotNull(message = "tipo")
	private int id_ideia;
	@NotNull(message = "tipo")
	private int id_pessoa;
	@NotNull(message = "tipo")
	private float nota;

	public int getId_ideia() {
		return id_ideia;
	}

	public void setId_ideia(int id_ideia) {
		this.id_ideia = id_ideia;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public int getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

}
