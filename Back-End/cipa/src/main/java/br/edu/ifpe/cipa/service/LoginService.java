package br.edu.ifpe.cipa.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Pessoa;

@Service
public class LoginService {
		
	
	PessoaDao pessoas = new PessoaDao();

	
	public boolean auth(String email, String senha) throws SQLException {
		List<Pessoa> allPessoas = pessoas.listar();
		boolean value = false;
		for (Iterator<Pessoa> iterator = allPessoas.iterator(); iterator.hasNext(); ) { 
			Pessoa p = iterator.next(); 
			if (p.getEmail().equals(email)) {
				value = true;
			}
		}
		return value;		
	}
}
