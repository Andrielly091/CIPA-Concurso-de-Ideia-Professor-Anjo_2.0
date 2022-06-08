package br.edu.ifpe.email.controller;

import br.edu.ifpe.email.model.Email;
import br.edu.ifpe.email.service.EmailService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@AllArgsConstructor
@RequestMapping("api/email")
public class EmailController {

	@Autowired
    private EmailService emailService;

    @PostMapping
    public void enviarEmail(@RequestBody Email email) throws MessagingException {
        emailService.enviarEmail(email);
    }

}
