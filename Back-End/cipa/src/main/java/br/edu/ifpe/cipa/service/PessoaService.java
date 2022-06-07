package br.edu.ifpe.cipa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Emaill;
import br.edu.ifpe.cipa.model.Pessoa;

@Service
public class PessoaService {
	
	@Autowired
	private SendEmailService emailSend;
	
	PessoaDao pessoadao = new PessoaDao();
	
	public List<Pessoa> listar() {
		return pessoadao.listar();
	}
	
	public void alterar(Pessoa pessoa) {
		pessoadao.alterar(pessoa);
	}
	
	public void inserir(Pessoa pessoa) {
//		Emaill email = new Emaill();
//		email.setEmailTo("jadeilsom@gmail.com");
//	    email.setEmailFrom("jadeilsonm17@gmail.com");
//	    email.setSubject("teste");
//	    email.setText("Teste de envio de email java");
//	    email.setAwnerRef("Cipa");
//		emailSend.sendEmail(email);
		pessoadao.inserir(pessoa);
	}
	
	public void remover(int id) {
		pessoadao.remover(id);
	}
	
}
