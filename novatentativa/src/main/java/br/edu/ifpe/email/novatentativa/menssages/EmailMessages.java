package br.edu.ifpe.email.novatentativa.menssages;

import br.edu.ifpe.email.novatentativa.model.User;

public class EmailMessages {
	
	public static String createTitle(User user) {
		return user.getNome() + "seu cadastro foi recebido!";	
	}
	
	public static String messageToNewUser(User user, String senha) {
		return "Olá" + user.getNome()
		+"! Seja muito bem-vindo(a) em nosso site."
		+ "Os seus dados e sua senha de acesso estão logo abaixo. \n\n"
		+"========================================== \n"
		+"Name: " + user.getNome() + "\n"
		+"E-mail: " + user.getEmail() + "\n"
		+"Name: " + user.getSenha() + "\n"
		+"======================================== \n\n"
		+"É importante acessar sua conta e trocar sua senha. \n"
		+"https://google.com";
		
	}
	

}
