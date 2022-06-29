package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpe.cipa.model.Pessoa;

public class PessoaDao {

    Connection connection = Conexao.getConexaoMySQL();

    public List<Pessoa> listarAll() {
        String sql = "SELECT id, nome, email, tipo_usuario FROM pessoas";
        List<Pessoa> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Pessoa newPessoa = new Pessoa();
                newPessoa.setId(resultado.getInt("id"));
                newPessoa.setNome(resultado.getString("nome"));
                newPessoa.setEmail(resultado.getString("email"));
                newPessoa.setTipo(resultado.getString("tipo_usuario"));
                retorno.add(newPessoa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }


    public List<Pessoa> listar() {
        String sql = "SELECT * FROM pessoas";
        List<Pessoa> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Pessoa cliente = new Pessoa();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setSenha(resultado.getString("senha"));
                cliente.setTipo(resultado.getString("tipo_usuario"));
                retorno.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean inserir(Pessoa newPessoa) {
        String sql = "INSERT INTO pessoas(nome, email,senha, tipo_usuario) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newPessoa.getNome().substring(0, 1).toUpperCase()
                    + newPessoa.getNome().substring(1));
            stmt.setString(2, newPessoa.getEmail());
            stmt.setString(3, newPessoa.getSenha());
            stmt.setString(4, newPessoa.getTipo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome=?, email=?, senha=?, tipo_usuario=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setString(4, pessoa.getTipo());
            stmt.setInt(5, pessoa.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM pessoas WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
