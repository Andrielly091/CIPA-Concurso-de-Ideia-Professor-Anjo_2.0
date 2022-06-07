package br.edu.ifpe.cipa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.cipa.model.Emaill;
//import br.edu.ifpe.cipa.dao.PessoaDao;
import br.edu.ifpe.cipa.model.Pessoa;
import br.edu.ifpe.cipa.service.PessoaService;
import br.edu.ifpe.cipa.service.SendEmailService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private SendEmailService email;
	
	PessoaService pessoaservice = new PessoaService();
	
	private final PasswordEncoder encoder;
	public PessoaController(PasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	
	@GetMapping("")
	public ResponseEntity<List<Pessoa>> list(){
		System.out.println("===== Lista Pessoas ====");
		
		
		return ResponseEntity.ok(pessoaservice.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> consultarPessoaPorId(@PathVariable Integer id){
		try {
			System.out.println("===== Lista Pessoas por Id ====");
			List<Pessoa> allUser = pessoaservice.listar();
			if (allUser.size() >= (id - 1)) {
				System.out.println("entrou");
				return new ResponseEntity<Pessoa>(allUser.get((id - 1)), HttpStatus.OK);				
			}
			return (ResponseEntity.notFound().build());
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void add(@Valid @RequestBody Pessoa pessoa) {
		System.out.println("===== inserir Pessoas ====");
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		Emaill email1 = new Emaill();
		email1.setEmailTo("jadeilsom.m@gmail.com");
	    email1.setEmailFrom("jadeilsonm17@gmail.com");
	    email1.setSubject("teste");
	    email1.setText("Teste de envio de email java");
	    email1.setAwnerRef("Cipa");
		email.sendEmail(email1);
		pessoaservice.inserir(pessoa);
	}
	
	@DeleteMapping("/r/{id}")
	public void remove(@PathVariable Integer id) {
		System.out.println("===== Remove Pessoas ====");
		pessoaservice.remover(id);
	}
	
	@PutMapping("/u")
	public void update(@RequestBody Pessoa pessoa) {
		System.out.println("===== Atualiza Pessoas ====");
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		System.out.println(pessoa.getSenha());
		pessoaservice.alterar(pessoa);
	}

}
