package br.edu.ifpe.cipa.service;


import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.edu.ifpe.cipa.model.Emaill;

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
 