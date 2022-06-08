package br.edu.ifpe.cipa.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Pessoa;

@Service
public class PessoaService {
	
	
	PessoaDao pessoadao = new PessoaDao();
	
	public List<Pessoa> listar() {
		return pessoadao.listar();
	}
	
	public void alterar(Pessoa pessoa) {
		pessoadao.alterar(pessoa);
	}
	
	public boolean inserir(Pessoa pessoa) {
		List<Pessoa> allPessoas = pessoadao.listar();
		var value = false;
		for (Iterator<Pessoa> iterator = allPessoas.iterator(); iterator.hasNext(); ) { 
			Pessoa p = iterator.next(); 
			int id = pessoa.getId();
			if (p.getEmail().equals(pessoa.getEmail())) {
				value = true;
			}
		}
		if(value == false) {
			pessoadao.inserir(pessoa);
			return true;
		} else {
			return false;
		}
	}
	
	public void remover(int id) {
		pessoadao.remover(id);
	}
	
}
