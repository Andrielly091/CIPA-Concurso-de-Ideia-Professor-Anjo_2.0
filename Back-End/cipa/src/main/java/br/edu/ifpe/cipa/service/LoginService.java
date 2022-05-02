package br.edu.ifpe.cipa.service;

import java.util.List;

import br.edu.ifpe.cipa.dao.LoginDao;
import br.edu.ifpe.cipa.model.Login;

public class LoginService {
	
	LoginDao logindao = new LoginDao();
	
	public List<Login> listar() {
		return logindao.listar();
	}
	
	public void alterar(Login loginBd) {
		logindao.alterar(loginBd);
	}
	
	public void inserir(Login login) {
		logindao.inserir(login);
	}
	
	public void remover(int loginId) {
		logindao.remover(loginId);
	}
}
