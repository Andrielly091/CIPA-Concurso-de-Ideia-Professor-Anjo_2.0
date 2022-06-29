package br.edu.ifpe.cipa.service;

import java.util.List;

import br.edu.ifpe.cipa.dao.VotacaoDao;
import br.edu.ifpe.cipa.model.RelatorioVotacao;

public class VotacaoService {

  VotacaoDao votacaodao = new VotacaoDao();

  public List<RelatorioVotacao> listar() {
    return votacaodao.listar();
  }
  
}
