package br.edu.ifpe.cipa.service;

import java.util.List;

import br.edu.ifpe.cipa.dao.IdeiasDao;
import br.edu.ifpe.cipa.model.Ideias;
import br.edu.ifpe.cipa.model.Pessoa;

public class IdeiasService {
	IdeiasDao ideiasdao = new IdeiasDao();
	
	public void inserir(Ideias Ideias) {
		ideiasdao.inserir(Ideias);
	}

	public List<Ideias> listar() {
		return ideiasdao.listar();
	}
}
