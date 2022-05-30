package br.edu.ifpe.email.novatentativa.service;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EnviarEmailService {

	@Autowired
	private final JavaMailSender envioEmailDoJava;

	public EnviarEmailService(final JavaMailSender javaMailSender) {
		this.envioEmailDoJava = javaMailSender;

	}
	public void enviar(String para, String titulo, String conteudo) {
		Log log = null;
		log.info("Enviando email para confirmação de cadastro..");
		
		var mensagem = new SimpleMailMessage();
		
		mensagem.setTo(para);
		mensagem.setSubject(titulo);
		mensagem.setText(conteudo);
		envioEmailDoJava.send(mensagem);
		
		log.info("Email enviado com sucesso!");
	}

}
