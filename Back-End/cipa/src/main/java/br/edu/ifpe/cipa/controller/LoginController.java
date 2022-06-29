package br.edu.ifpe.cipa.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.cipa.model.Pessoa;
import br.edu.ifpe.cipa.model.Response;
import br.edu.ifpe.cipa.service.LoginService;
import br.edu.ifpe.cipa.service.PessoaService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/login")
public class LoginController<senha> {

	LoginService loginservice = new LoginService();
	
	private final PasswordEncoder encoder;

	
	public LoginController(PasswordEncoder encoder) {
		super();
		this.encoder = encoder;
	}


	@PostMapping("")
	public ResponseEntity<Response> auth (@RequestBody Pessoa login) throws SQLException {
		Response response = new Response();
		PessoaService pessoaservice = new PessoaService();
		ResponseEntity<Response> re;
		var value = loginservice.auth(login.getEmail(), login.getSenha());
		if(value == false) {
			response.setMensagem("Falha na autenticação");
			response.setAuth("false");
			re = new ResponseEntity<Response>(response, HttpStatus.UNAUTHORIZED);
		}
		try {
			List<Pessoa> retorno = pessoaservice.findEmail(login.getEmail());
			boolean valid = encoder.matches(login.getSenha(), retorno.get(0).getSenha());
			if (valid == true) {
				retorno.get(0).setSenha(null);
				response.setAuth("true");
				response.setMensagem("Autenticação");
				response.setPessoas(retorno);
				re = new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
			} else {
				response.setAuth("false");
				response.setMensagem("Falha na autenticação");
				re = new ResponseEntity<Response>(response, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			response.setAuth("false");
			response.setMensagem(e.getMessage());
			re = new ResponseEntity<Response>(response, HttpStatus.UNAUTHORIZED);
		}
		return re;
	}


	@PutMapping("/esqueceuSenha/{loginId}")
	public void alterar(@PathVariable Integer loginId, @PathVariable String senha) {
		loginservice.alterar(loginId, senha);

	}
}
