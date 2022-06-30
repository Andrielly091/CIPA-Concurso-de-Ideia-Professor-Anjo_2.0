package br.edu.ifpe.cipa.service;

import java.util.List;

import br.edu.ifpe.cipa.dao.VotacaoDao;
import br.edu.ifpe.cipa.model.RelatorioVotacao;
import br.edu.ifpe.cipa.model.Votacao;

public class VotacaoService {

	VotacaoDao votacaodao = new VotacaoDao();

	PessoaService pessoaservice = new PessoaService();

	IdeiasService ideiasservice = new IdeiasService();

	public List<RelatorioVotacao> listar() {
		return votacaodao.listar();
	}

	public boolean add(Votacao newVotacao) throws Exception {
		if (!pessoaservice.entidadeJaExisteId(newVotacao.getId_pessoa())) {
			throw new Exception("Pessoa não existe");
		} else if (!ideiasservice.entidadeJaExisteId(newVotacao.getId_ideia())) {
			throw new Exception("Ideia não existe");
		}
		return votacaodao.inserir(newVotacao);
	}

}
