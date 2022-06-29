package br.edu.ifpe.cipa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.cipa.model.RelatorioVotacao;
import br.edu.ifpe.cipa.service.VotacaoService;



@RestController
@RequestMapping("/votacao")
public class VotacaoController {

  VotacaoService votacaoservice = new VotacaoService();

  @GetMapping("")
  public List<RelatorioVotacao> listar() {
    return votacaoservice.listar();
  }

  
}
