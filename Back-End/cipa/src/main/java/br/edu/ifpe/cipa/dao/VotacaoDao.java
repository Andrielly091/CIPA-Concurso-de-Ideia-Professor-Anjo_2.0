package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpe.cipa.model.RelatorioVotacao;
import br.edu.ifpe.cipa.model.Votacao;

public class VotacaoDao {

  Connection connection = Conexao.getConexaoMySQL();

  public boolean inserir(Votacao newVotacao) {
    String sql = "INSERT INTO notas_ideias(id_pessoa, id_ideia, nota) VALUES(?,?,?)";
    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, newVotacao.getId_ideia());
        stmt.setInt(2, newVotacao.getId_pessoa());
        stmt.setFloat(3, newVotacao.getNota());
        stmt.execute();
        return true;
    } catch (SQLException ex) {
        Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
  }  

  public List<RelatorioVotacao> listar() {
    String sql = "SELECT p.nome as nome, n.nota as nota, i.nome as titulo FROM notas_ideias as n"
    +" inner join pessoas as p on n.id_pessoa = p.id"
    +" inner join ideias as i on n.id_ideia = i.id_ideia";
    List<RelatorioVotacao> retorno = new ArrayList<>();
    try {
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();
        while (resultado.next()) {
            RelatorioVotacao votacao = new RelatorioVotacao();
            votacao.setNota(resultado.getFloat("nota"));
            votacao.setNome(resultado.getString("nome"));
            votacao.setTitulo(resultado.getString("titulo"));
            retorno.add(votacao);
        }
    } catch (SQLException ex) {
        Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return retorno;
  }

}
