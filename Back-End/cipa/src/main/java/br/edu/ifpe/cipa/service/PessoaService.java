package br.edu.ifpe.cipa.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Pessoa;

@Service
public class PessoaService {
	
	
	PessoaDao pessoadao = new PessoaDao();
	
	public boolean entidadeJaExiste(String email) {
		return pessoadao.listar().stream().anyMatch(p -> p.getEmail().equals(email));
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
		if (this.entidadeJaExiste(pessoa.getEmail())) {
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

	public List<Pessoa> findEmail(String email) throws Exception {
		if (!this.entidadeJaExiste(email)) {
			throw new Exception("Email não encontrado");
		}
		Stream<Pessoa> result = pessoadao.listar().stream().filter(p -> p.getEmail().equals(email));
		List<Pessoa> resultado = result.collect(Collectors.toList());
		return resultado;
	}
	
}
