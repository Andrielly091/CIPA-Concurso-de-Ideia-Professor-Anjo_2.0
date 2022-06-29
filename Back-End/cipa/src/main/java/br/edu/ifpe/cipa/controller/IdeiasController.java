package br.edu.ifpe.cipa.controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.cipa.model.Ideias;
import br.edu.ifpe.cipa.model.Response;
import br.edu.ifpe.cipa.service.IdeiasService;

@RestController
@RequestMapping("/ideias")
public class IdeiasController {

	IdeiasService ideiasservice = new IdeiasService();

	@GetMapping("")
	public List<Ideias> list() {
		return ideiasservice.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> consultarIdeiasPorId(@PathVariable Integer id) throws Exception {
		Response response = new Response();
		ResponseEntity<Response> re;
		try {
			List<Ideias> result = ideiasservice.listarApenasPessoa(id);
			response.setIdeias(result);
			response.setMensagem("Buscando apenas uma ideia");
			response.setStatusCode(HttpStatus.OK);
			re = new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMensagem(e.getMessage());
			response.setStatusCode(HttpStatus.NOT_FOUND);
			re = new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@PostMapping("/")
	public boolean add(@RequestBody Ideias ideias) throws ClassNotFoundException, SQLException {
		return ideiasservice.inserir(ideias);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Integer id) {
		ideiasservice.Deletar(id);

	}

	@PutMapping("/")
	public void update(@RequestBody Ideias ideias) {

		ideiasservice.Atualizar(ideias);
	}

}
