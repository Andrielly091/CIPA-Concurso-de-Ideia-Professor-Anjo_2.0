package br.edu.ifpe.cipa.model;

public class Ideias {
	
	private int id_ideia;
	private String id_lider;
	private int id_concurso;
	private String imagem;
	private String temas_Impactados;
	private String resumo_do_projeto;
	private String video_demostrativo;
	private float nota;
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getId_ideia() {
		return id_ideia;
	}
	
	public String getId_lider() {
		return id_lider;
	}
	public void setId_lider(String id_lider) {
		this.id_lider = id_lider;
	}
	public int getId_concurso() {
		return id_concurso;
	}
	public void setId_concurso(int id_concurso) {
		this.id_concurso = id_concurso;
	}
	public String getTemas_Impactados() {
		return temas_Impactados;
	}
	public void setTemas_Impactados(String temas_Impactados) {
		this.temas_Impactados = temas_Impactados;
	}
	public String getResumo_do_projeto() {
		return resumo_do_projeto;
	}
	public void setResumo_do_projeto(String resumo_do_projeto) {
		this.resumo_do_projeto = resumo_do_projeto;
	}
	public String getVideo_demostrativo() {
		return video_demostrativo;
	}
	public void setVideo_demostrativo(String video_demostrativo) {
		this.video_demostrativo = video_demostrativo;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public void setId_ideia(int id_ideia) {
		this.id_ideia = id_ideia;
	}
	
}
