package br.edu.ifpe.cipa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import br.edu.ifpe.cipa.dao.IdeiasDao;
import br.edu.ifpe.cipa.model.Ideias;

@Service
public class IdeiasService {
	IdeiasDao ideiasdao = new IdeiasDao();

	public boolean inserir(Ideias Ideias) throws ClassNotFoundException, SQLException {
		return ideiasdao.inserir(Ideias);
	}

	public boolean entidadeJaExisteId(Integer id) {
		return ideiasdao.listar().stream().anyMatch(i -> i.getId_ideia() == id);
	}

	public List<Ideias> listar() {
		return ideiasdao.listar();
	}

	public void consultar(Ideias ideias) throws ClassNotFoundException, SQLException {
		ideiasdao.consultar(ideias);
	}

	public List<Ideias> listarApenasPessoa(int id) throws Exception {
		if (!this.entidadeJaExisteId(id)) {
			throw new Exception("Id não encontrado");
		}
		Stream<Ideias> result = ideiasdao.listar().stream().filter(p -> p.getId_ideia() == id);
		List<Ideias> resultado = result.collect(Collectors.toList());
		return resultado;
	}


	public void Deletar(int id) {
		ideiasdao.Deletar(id);
	
	}

	public void Atualizar(Ideias ideias) {
		ideiasdao.Atualizar(ideias);
	}
}
