package br.edu.ifpe.cipa.controller;

import java.util.List; 


import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import br.edu.ifpe.cipa.service.LoginService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/login")
public class LoginController<senha> {

	LoginService loginservice = new LoginService();
	
	@CrossOrigin
	@GetMapping("")
	public List<Login> list(){
		System.out.println("====  List Login  ====");
		return loginservice.listar();
	}
	

	@PostMapping("")
	public boolean auth(@RequestBody Login login) {
		return loginservice.auth(login.getEmail(), login.getSenha());
	}
	
	@GetMapping("/{loginId}")
	public ResponseEntity<Login> consultarUsuarioPorId(@PathVariable int loginId){
		try {
			return new ResponseEntity<Login>(loginservice.listar().get(loginId), HttpStatus.OK);
			}catch(NoSuchElementException e) {
			return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
		}
			
	}
	@PostMapping("/")
	public void add(@RequestBody Login inserir) {
		loginservice.inserir(inserir);
	}
	
	@DeleteMapping("/remover/{id}")
	public void remove(@PathVariable Integer id) {
		loginservice.remover(id);
	}
	
	@PutMapping("/esqueceuSenha/{loginId}")
	public void alterar(@PathVariable Integer loginId, @PathVariable String senha) {
		loginservice.alterar(loginId, senha);
	
	}
}












