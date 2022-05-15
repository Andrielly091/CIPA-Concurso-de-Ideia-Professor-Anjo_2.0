package br.edu.ifpe.cipa.model;

public class Ideias {
	
	private int idIdeias;
	private int idLider;
	private int idConcurso;
	private String temasImpactados;
	private String resumoDoProjeto;
	private String videoDemostrativo;
	private float nota;
	
	public int getIdIdeias() {
		return idIdeias;
	}
	public void setIdIdeias(int idIdeias) {
		this.idIdeias = idIdeias;
	}
	public int getIdLider() {
		return idLider;
	}
	public void setIdLider(int idLider) {
		this.idLider = idLider;
	}
	public int getIdConcurso() {
		return idConcurso;
	}
	public void setIdConcurso(int idConcurso) {
		this.idConcurso = idConcurso;
	}
	public String getTemasImpactados() {
		return temasImpactados;
	}
	public void setTemasImpactados(String temasImpactados) {
		this.temasImpactados = temasImpactados;
	}
	public String getResumoDoProjeto() {
		return resumoDoProjeto;
	}
	public void setResumoDoProjeto(String resumoDoProjeto) {
		this.resumoDoProjeto = resumoDoProjeto;
	}
	public String getVideoDemostrativo() {
		return videoDemostrativo;
	}
	public void setVideoDemostrativo(String videoDemostrativo) {
		this.videoDemostrativo = videoDemostrativo;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	
}
