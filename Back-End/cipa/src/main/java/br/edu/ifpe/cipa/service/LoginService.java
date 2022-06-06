package br.edu.ifpe.cipa.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.dao.LoginDao;
import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Login;
import br.edu.ifpe.cipa.model.Pessoa;

@Service
public class LoginService {
	
	private final
		
	LoginDao logindao = new LoginDao();
	
	PessoaDao pessoas = new PessoaDao();
	
	
	public List<Login> listar() throws ClassNotFoundException, SQLException {
		return logindao.listar();
	}
	
	public Login alterar(Login loginBd) throws ClassNotFoundException, SQLException {
		logindao.alterar(loginBd);
		return loginBd;
		
	}
	
	public void inserir(Login login) throws ClassNotFoundException, SQLException {
		logindao.inserir(login);
	}
	
	public void remover(int loginId) throws ClassNotFoundException, SQLException {
		logindao.remover(loginId);
	}

	public void sendEmail() {
		
	}
	
	public Pessoa auth(String email, String senha) throws SQLException {
		
		List<Pessoa> allPessoas = pessoas.listar();
				
		Pessoa value = null;
		for (Iterator<Pessoa> iterator = allPessoas.iterator(); iterator.hasNext(); ) { 
			Pessoa p = iterator.next(); 
			if (p.getEmail().equals(email)) {
				value = p;
			}
		}
		System.out.println(value);
		return value;
		
		
	}

	public void alterar(Integer loginId, String senha) {
		// TODO Auto-generated method stub
		
	}

}
