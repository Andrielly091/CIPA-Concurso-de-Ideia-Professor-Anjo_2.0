package br.edu.ifpe.cipa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Pessoa;

@Service
public class PessoaService {
	
	
	PessoaDao pessoadao = new PessoaDao();
	
	public boolean entidadeJaExiste(Pessoa pessoa) {
		return pessoadao.listar().stream().anyMatch(p -> p.getEmail().equals(pessoa.getEmail()));
	}

	public boolean entidadeJaExisteEmail(Integer id, String email) {
		return pessoadao.listar().stream().filter(p -> p.getEmail().equals(email)).anyMatch(p -> p.getId() == id);
	}

	public boolean entidadeJaExisteId(Integer id) {
		return pessoadao.listar().stream().anyMatch(p -> p.getId() == id);
	}

	public List<Pessoa> listar() {
		return pessoadao.listar();
	}

	public Pessoa listarOne(Integer id) throws Exception {
		if (!this.entidadeJaExisteId(id)) {
			throw new Exception("Id não encontrado");
		}		
		return pessoadao.listar().get(id - 1);
	}
	
	public void alterar(Pessoa pessoa) throws Exception {
		if (!this.entidadeJaExisteId(pessoa.getId())) {
			throw new Exception("Pessoa não existe");
		} else if (!this.entidadeJaExisteEmail(pessoa.getId(), pessoa.getEmail())) {
			throw new Exception("Email já esta cadastrado em outra conta");
		}
		pessoadao.alterar(pessoa);
	}

	
	public void inserir(Pessoa pessoa) throws Exception {
		if (this.entidadeJaExiste(pessoa)) {
			throw new Exception("Pessoa ja cadastrado");
		}
		pessoadao.inserir(pessoa);
	
	}
	
	public void remover(int id) throws Exception {
		if (!this.entidadeJaExisteId(id)) {
			throw new Exception("Pessoa não existe");
		}
		pessoadao.remover(id);
	}
	
}
