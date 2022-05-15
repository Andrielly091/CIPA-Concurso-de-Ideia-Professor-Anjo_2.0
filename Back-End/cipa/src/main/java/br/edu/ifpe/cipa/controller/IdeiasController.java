package br.edu.ifpe.cipa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.cipa.model.Ideias;
import br.edu.ifpe.cipa.model.Pessoa;
import br.edu.ifpe.cipa.service.IdeiasService;

@RestController
@RequestMapping("/Ideias")
public class IdeiasController {
	IdeiasService ideiasservice =  new IdeiasService();
	
	@GetMapping("")
	public List<Ideias> list(){
		return ideiasservice.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ideias> consultarPessoaPorId(@PathVariable Integer id){
		try {
			return new ResponseEntity<Ideias>(ideiasservice.listar().get(id), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Ideias>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/")
	public void add(@RequestBody Ideias ideias) {
		ideiasservice.inserir(ideias);
	}
}
