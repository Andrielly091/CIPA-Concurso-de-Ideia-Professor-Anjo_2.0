
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
		System.out.println("===== Lista Pessoas ====");
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
		try {
			System.out.println("===== Lista Pessoas por Id ====");
			Response response = new Response();
			List<Pessoa> allUser = pessoaservice.listar();
			if (allUser.size() >= (id - 1)) {
				response.setMensage("FindById");
				ArrayList<Pessoa> list = new ArrayList();
				add = list.add(allUser.get((id - 1)));
				response.setPessoas(list);
				response.setStatusCode(HttpStatus.OK);
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			}
			response.setMensage("Not Found");
			response.setStatusCode(HttpStatus.NOT_FOUND);
			return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Response>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Response> add(@Valid @RequestBody Pessoa pessoa) {
		System.out.println("===== INSERIR PESSOAS ====");
		Response response = new Response();
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		boolean isCreated = pessoaservice.inserir(pessoa);
		if (isCreated) {
			response.setMensage("create person: " + pessoa.getNome());
			response.setStatusCode(HttpStatus.CREATED);
			response.setCreated("true");
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		}
		response.setMensage("Not created");
		response.setStatusCode(HttpStatus.NOT_FOUND);
		response.setCreated("false");
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findEmail/{email}")
	public Pessoa findByEmail(@PathVariable String email) {
		System.out.println("==== FIND EMAIL ====");
		List<Pessoa> allPessoas = pessoaservice.listar();
		Pessoa value = null;
		for (Iterator<Pessoa> iterator = allPessoas.iterator(); iterator.hasNext();) {
			Pessoa p = iterator.next();
			System.out.println(p.getEmail());
			if (p.getEmail().equals(email)) {
				value = p;
			}
		}
		return value;
	}

	@DeleteMapping("/r/{id}")
	public void remove(@PathVariable Integer id) {
		System.out.println("===== REMOVE PESSOA ====");
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
