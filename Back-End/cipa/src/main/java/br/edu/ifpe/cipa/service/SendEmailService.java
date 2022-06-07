package br.edu.ifpe.cipa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.model.Emaill;

@Service
public class SendEmailService {
	
	@Autowired
	private final JavaMailSender emailSender;
	
	public SendEmailService(final JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}
	

	public Emaill sendEmail(Emaill email) {
        try{
        	System.out.println(emailSender);
        	System.out.println(email.getEmailFrom());
            var message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setFrom(email.getEmailFrom());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            System.out.println(message);
            emailSender.send(message);
            System.out.println(message);
            
            System.out.println("enviado!!!");
        } catch (MailException e){
        	System.out.println("error");
            System.out.println(e);
     
        }
        return email;
    }
}

 