package br.edu.ifpe.cipa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.cipa.model.RelatorioVotacao;
import br.edu.ifpe.cipa.model.Response;
import br.edu.ifpe.cipa.model.Votacao;
import br.edu.ifpe.cipa.service.VotacaoService;



@RestController
@RequestMapping("/votacao")
public class VotacaoController {

  VotacaoService votacaoservice = new VotacaoService();

  @GetMapping("")
  public List<RelatorioVotacao> listar() {
    return votacaoservice.listar();
  }

  @PostMapping("/")
  public ResponseEntity<Response> add(@Valid @RequestBody Votacao votacao) {
    Response response = new Response();
    ResponseEntity<Response> re;
    try {
      boolean valid = votacaoservice.add(votacao);
      if (valid) {
        response.setMensagem("Votação OK");
        response.setStatusCode(HttpStatus.OK);
        response.setCreated("true");
        re = new ResponseEntity<Response>(response, HttpStatus.OK);
      } else {
        response.setMensagem("Falha na Votação");
        response.setStatusCode(HttpStatus.NOT_FOUND);
        response.setCreated("false");
        re = new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      response.setMensagem(e.getMessage());
      response.setStatusCode(HttpStatus.NOT_FOUND);
      response.setCreated("false");
      re = new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }
    return re;
  }
  
}
