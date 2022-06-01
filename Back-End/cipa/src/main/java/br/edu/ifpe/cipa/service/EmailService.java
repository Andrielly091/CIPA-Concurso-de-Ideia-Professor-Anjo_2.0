package br.edu.ifpe.cipa.service;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.edu.ifpe.cipa.dao.EmailDao;
import br.edu.ifpe.cipa.model.Email;

public class EmailService {
	public boolean enviarEmail(){
		
	         
	            final String username = "";
	            final String password = "";

	            Properties props = new Properties();
	            props.put("mail.smtp.host", "smtp.gmail.com");
	            props.put("mail.smtp.socketFactory.port", "465");
	            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.port", "465");

	            Session session = Session.getDefaultInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	            try {

	                Message message = new MimeMessage(session);
	                message.setFrom(new InternetAddress("cipa@gmail.com"));
	                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("adrilysilva8@gmail.com"));
	                message.setSubject("Receitas de Código Adriely: Assunto do E-mail");
	                message.setText("Olá.!! Este e-mail foi enviado usando javamail");

	                Transport.send(message);

	                System.out.println("Pronto!");

	            } catch (MessagingException e) {
	                throw new RuntimeException(e);
	            }
				return true;
	        }
	EmailDao emaildao = new EmailDao();

	public void inserir(Email inserir) throws ClassNotFoundException, SQLException {
		emaildao.inserir(inserir);
	}

	public void remover(int emailID) throws ClassNotFoundException, SQLException {
		emaildao.remover(emailID);
	}

	public void alterar(Email idMail, String senha) throws ClassNotFoundException, SQLException {
		emaildao.alterar(idMail);
		return;
	
}}
