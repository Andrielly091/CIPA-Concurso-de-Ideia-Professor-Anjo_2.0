package br.edu.ifpe.cipa.controller;

import java.sql.SQLException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ifpe.cipa.model.Email;
import br.edu.ifpe.cipa.service.EmailService;

public class EmailController {
	
	EmailService emailservice = new EmailService();
	@PostMapping("/inserirEmail")
	public void add(@RequestBody Email inserir) throws ClassNotFoundException, SQLException {
		emailservice.inserir(inserir);
	}
	
	@DeleteMapping("/apagarEmail/{idMail}")
	public void remove(@PathVariable Integer id) throws ClassNotFoundException, SQLException {
		emailservice.remover(id);
	}
	
	@PutMapping("/alterarSenha/{idMail}")
	public void alterar(@PathVariable Email idMail, @PathVariable String senha) throws ClassNotFoundException, SQLException {
		emailservice.alterar(idMail, senha);
	
	}

}
