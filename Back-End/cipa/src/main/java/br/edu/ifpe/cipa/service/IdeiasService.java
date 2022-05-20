package br.edu.ifpe.cipa.service;

import java.sql.SQLException;
import java.util.List;
import br.edu.ifpe.cipa.dao.IdeiasDao;
import br.edu.ifpe.cipa.model.Ideias;

	public class IdeiasService {
		IdeiasDao ideiasdao = new IdeiasDao();
		
		public void inserir(Ideias Ideias) {
			ideiasdao.inserir(Ideias);
		}

		public List<Ideias> listar() {
			return ideiasdao.listar();
		}
		public void consultar(Ideias ideias) throws ClassNotFoundException, SQLException {
			ideiasdao.consultar(ideias);
		}
}
