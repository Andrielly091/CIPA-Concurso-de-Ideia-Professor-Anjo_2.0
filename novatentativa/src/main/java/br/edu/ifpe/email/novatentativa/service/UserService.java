package br.edu.ifpe.email.novatentativa.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.email.novatentativa.menssages.EmailMessages;
import br.edu.ifpe.email.novatentativa.model.User;

@Service
public class UserService {
	
	@Autowired
	private EnviarEmailService enviarEmailService;
	
	public User save(User user) {
		this.validUserData(user);
		
		var newUser = new User(user.getNome(), user.getEmail());
		newUser.setSenha(UUID.randomUUID().toString());
		
		this.enviarEmailService.enviar(user.getEmail(),
				EmailMessages.createTitle(user), EmailMessages.messageToNewUser(user, newUser.getSenha()));
		
		newUser.setSenha("******");
	
		return newUser;	
	}

	private void validUserData(User user) {
		if(user.getNome() == null || user.getEmail() == null) {
			throw new RuntimeException("todos os campos precisam ser informados");
			
		}
		
	}

}
