package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpe.cipa.model.Pessoa;

public class PessoaDao { 
	
	private Connection connection;
		
	 public PessoaDao() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
	            String DATABASE_URL = "jdbc:mysql://localhost/cliente_bd_ifpe";
=======
	            String DATABASE_URL = "jdbc:mysql://localhost/cipa";
>>>>>>> 4e569c1f0e300b4683fd4a1d63be90b39b674540
	            String usuario = "root";
	            String senha = "";
	            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	
	public List<Pessoa> listar() {
        String sql = "SELECT * FROM pessoas";
        List<Pessoa> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Pessoa cliente = new Pessoa();
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

    public boolean inserir(Pessoa cliente) {
        String sql = "INSERT INTO pessoas(nome, email, senha, tipo_usuario) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getTipo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Pessoa pessoa) {
        String sql = "UPDATE cliente SET nome=?, senha=?, tipo_usuario=? WHERE email=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSenha());
            stmt.setString(3, pessoa.getTipo());
            stmt.setString(4, pessoa.getEmail());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer email) {
        String sql = "DELETE FROM cliente WHERE email=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, email);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
