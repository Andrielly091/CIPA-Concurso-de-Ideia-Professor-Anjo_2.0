package br.edu.ifpe.cipa.service;

import java.util.Iterator;
import java.util.List; 

import br.edu.ifpe.cipa.dao.LoginDao;
import br.edu.ifpe.cipa.model.Login;

public class LoginService {
	
	LoginDao logindao = new LoginDao();
	
	public List<Login> listar() {
		return logindao.listar();
	}
	
	public Login alterar(Login loginBd) {
		logindao.alterar(loginBd);
		return loginBd;
		
	}
	
	public void inserir(Login login) {
		logindao.inserir(login);
	}
	
	public void remover(int loginId) {
		logindao.remover(loginId);
	}

	public void alterar(int loginId, String senha) {
		// TODO Auto-generated method stub
		
	}
	public boolean auth(String email, String senha) {
		List<Login> listLogins = logindao.listar();
		System.out.println("Params");
		boolean value = false;
		for (Iterator<Login> iterator = listLogins.iterator(); iterator.hasNext(); ) { 
			Login l = (Login) iterator.next(); 
			if (l.getEmail().equals(email) && l.getSenha().equals(senha)) {
				value = true;
			}
		}
		return 	value;
	}

}
