package br.edu.ifpe.cipa.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
=======

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
>>>>>>> main
import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.model.Emaill;

<<<<<<< HEAD
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

=======
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class SendEmailService {

	@Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(Emaill email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);

        mimeMessageHelper.setFrom(email.getFrom());
        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.setText(email.getText());

        javaMailSender.send(message);
        
        System.out.println("Email enviado!");
    }
}
>>>>>>> main
 