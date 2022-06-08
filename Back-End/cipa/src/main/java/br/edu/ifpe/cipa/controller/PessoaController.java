package br.edu.ifpe.cipa.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifpe.cipa.model.Pessoa;
import br.edu.ifpe.cipa.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {


	PessoaService pessoaservice = new PessoaService();

	private final PasswordEncoder encoder;

	public PessoaController(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@GetMapping("")
	public ResponseEntity<List<Pessoa>> list() {
		System.out.println("===== Lista Pessoas ====");

		return ResponseEntity.ok(pessoaservice.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> consultarPessoaPorId(@PathVariable Integer id) {
		try {
			System.out.println("===== Lista Pessoas por Id ====");
			List<Pessoa> allUser = pessoaservice.listar();
			if (allUser.size() >= (id - 1)) {
				return new ResponseEntity<Pessoa>(allUser.get((id - 1)), HttpStatus.OK);
			}
			return (ResponseEntity.notFound().build());
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public boolean add(@Valid @RequestBody Pessoa pessoa) {
		System.out.println("===== inserir Pessoas ====");
//		System.out.println(id);
		pessoa.setSenha(encoder.encode(pessoa.getSenha()));
		return pessoaservice.inserir(pessoa);
	}
	
	@GetMapping("/findEmail/{email}")
	public Pessoa findByEmail(@PathVariable String email) {
		System.out.println("Find email");
//		System.out.println(email);
		List<Pessoa> allPessoas = pessoaservice.listar();
		Pessoa value = null;
		for (Iterator<Pessoa> iterator = allPessoas.iterator(); iterator.hasNext(); ) { 
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
