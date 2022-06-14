package br.edu.ifpe.cipa.controller;

import java.sql.SQLException;
import java.util.Iterator;
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
import br.edu.ifpe.cipa.model.Response;
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
		public ResponseEntity<Response> consultarIdeiasPorId(@PathVariable String id){
			
			try {
				Response response = new Response();
				boolean value = false;
				int number = Integer.parseInt(id);

			List<Ideias> ideias = ideiasservice.listar();	
			    for (Iterator<Ideias> iterator = ideias.iterator(); iterator.hasNext(); ) { 
				Ideias i = iterator.next(); 
				if (i.getId_ideias() == (number)) {
					value = true;
				}
				
			}
			    if (value == true){
			    	List<Ideias> ideiaRetorno = ideiasservice.listarApenas1(number);
			    	response.setIdeias(ideiaRetorno);
					response.setStatusCode(HttpStatus.OK);
			    	return new ResponseEntity<Response>(response,HttpStatus.OK);
			    }
			    response.setMensage("Not Found");
				response.setStatusCode(HttpStatus.NOT_FOUND);
				return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
			}catch(NoSuchElementException e) {
			 return new ResponseEntity<Response>(HttpStatus.NOT_FOUND);

			}
		}
		
		@PostMapping("/")
		public boolean add(@RequestBody Ideias ideias) throws ClassNotFoundException, SQLException {
			return ideiasservice.inserir(ideias);
		}
		
		
		
}


	
