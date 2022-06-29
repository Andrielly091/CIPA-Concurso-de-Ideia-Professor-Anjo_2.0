
package br.edu.ifpe.cipa.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;

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
import br.edu.ifpe.cipa.model.Pessoa;
import br.edu.ifpe.cipa.model.Response;
import br.edu.ifpe.cipa.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	PessoaService pessoaservice = new PessoaService();

	private final PasswordEncoder encoder;

	private boolean add;

	public PessoaController(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@GetMapping("")
	public ResponseEntity<Response> list() {
		Response response = new Response();
		List<Pessoa> allPessoas = pessoaservice.listar();
		response.setMensage("FindAll");
		response.setPessoas(allPessoas);
		response.setStatusCode(HttpStatus.OK);
		response.setCreated("false");
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> consultarPessoaPorId(@PathVariable Integer id) {
		Response response = new Response();

		ResponseEntity<Response> re;
		try {
			response.setMensage("FindById");
			ArrayList<Pessoa> list = new ArrayList();
			list.add(pessoaservice.listarOne(id));
			response.setPessoas(list);
			response.setStatusCode(HttpStatus.OK);
			re = new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMensage(e.getMessage());
			response.setStatusCode(HttpStatus.NOT_FOUND);
			re = new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@PostMapping("/")
	public ResponseEntity<Response> add(@Valid @RequestBody Pessoa pessoa) {
		Response response = new Response();

		ResponseEntity<Response> re;
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));

		try {
			response.setMensage("create person: " + pessoa.getNome());
			response.setStatusCode(HttpStatus.CREATED);
			response.setCreated("true");
			re = new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.setMensage(e.getMessage());
			response.setStatusCode(HttpStatus.NOT_FOUND);
			response.setCreated("false");
			re = new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		}
		return re;
	}

	@GetMapping("/findEmail/{email}")
	public Pessoa findByEmail(@PathVariable String email) {
		List<Pessoa> allPessoas = pessoaservice.listar();
		Pessoa value = null;
		for (Iterator<Pessoa> iterator = allPessoas.iterator(); iterator.hasNext();) {
			Pessoa p = iterator.next();
			if (p.getEmail().equals(email)) {
				value = p;
			}
		}
		return value;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		pessoaservice.remover(id);
	}

	@PutMapping("/")
	public void update(@RequestBody Pessoa pessoa) {
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		pessoaservice.alterar(pessoa);
	}
}
