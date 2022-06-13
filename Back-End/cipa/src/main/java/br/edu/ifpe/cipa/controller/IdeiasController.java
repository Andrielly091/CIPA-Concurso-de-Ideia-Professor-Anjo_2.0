package br.edu.ifpe.cipa.controller;

import java.sql.SQLException;
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
@RequestMapping("/ideias")
public class IdeiasController {
	
		IdeiasService ideiasservice =  new IdeiasService();
		
		@GetMapping("")
		
		public List<Ideias> list(){
			return ideiasservice.listar();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Ideias> consultarIdeiasPorId(@PathVariable Integer id){
			try {
				return new ResponseEntity<Ideias>(ideiasservice.listar().get(id), HttpStatus.OK);
			}catch(NoSuchElementException e) {
				return new ResponseEntity<Ideias>(HttpStatus.NOT_FOUND);
			}
		}
		
		@PostMapping("/")
		public boolean add(@RequestBody Ideias ideias) throws ClassNotFoundException, SQLException {
			return ideiasservice.inserir(ideias);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Ideias> consultarIdeiaPorId(@PathVariable Integer id) {
			try {
				System.out.println("===== Lista Ideias por Id ====");
				List<Ideias> allUser = ideiasservice.listar();
				if (allUser.size() >= (id - 1)) {
					return new ResponseEntity<Ideias>(allUser.get((id - 1)), HttpStatus.OK);
				}
				return (ResponseEntity.notFound().build());
			} catch (NoSuchElementException e) {
				return new ResponseEntity<Ideias>(HttpStatus.NOT_FOUND);
			}
		}
}


	
