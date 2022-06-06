package br.edu.ifpe.cipa.controller;

import java.sql.SQLException;
import java.util.List; 


import java.util.NoSuchElementException;	
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifpe.cipa.model.Login;
import br.edu.ifpe.cipa.model.Pessoa;
import br.edu.ifpe.cipa.service.LoginService;

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

	@CrossOrigin
	@GetMapping("")
	public List<Login> list() throws ClassNotFoundException, SQLException{
		System.out.println("====  List Login  ====");
		return loginservice.listar();
	}
	
	@GetMapping("/enviar")
	public void enviar(){
		loginservice.sendEmail();
	}
	

	@PostMapping("")
	public ResponseEntity<Object> auth (@RequestBody Pessoa login) throws SQLException {
		System.out.println("===== Autenticação ====");
		Pessoa value = loginservice.auth(login.getEmail(), login.getSenha());
		if((value == null)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(value);
		}

	
		boolean valid = encoder.matches(login.getSenha(), value.getSenha());
		System.out.println(valid);
		
		if (valid == true) {
			value.setSenha(null);
			value.setAuth(true);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(value);
		} else {
			value.setId(999999999);
			value.setNome(null);
			value.setEmail(null);
			value.setSenha(null);
			value.setAuth(false);
			value.setTipo(null);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(value);
			
		}
		
		
		
	}
	
	@GetMapping("/{loginId}")
	public ResponseEntity<Login> consultarUsuarioPorId(@PathVariable int loginId) throws ClassNotFoundException, SQLException{
		try {
			return new ResponseEntity<Login>(loginservice.listar().get(loginId), HttpStatus.OK);
			}catch(NoSuchElementException e) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		}
			
	}
	@PostMapping("/")
	public void add(@RequestBody Login inserir) throws ClassNotFoundException, SQLException {
		loginservice.inserir(inserir);
	}
	
	@DeleteMapping("/remover/{id}")
	public void remove(@PathVariable Integer id) throws ClassNotFoundException, SQLException {
		loginservice.remover(id);
	}
	
	@PutMapping("/esqueceuSenha/{loginId}")
	public void alterar(@PathVariable Integer loginId, @PathVariable String senha) {
		loginservice.alterar(loginId, senha);
	
	}
}












