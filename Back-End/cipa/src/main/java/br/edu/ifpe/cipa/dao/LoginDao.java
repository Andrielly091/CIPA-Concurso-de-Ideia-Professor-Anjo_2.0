package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpe.cipa.model.Login;

public class LoginDao {
	
	Connection connection = Conexao.getConexaoMySQL();

	public List<Login> listar() {
        String sql = "SELECT * FROM login";
        List<Login> resposta = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Login login = new Login();
                login.setLoginId(resultado.getInt("loginId"));
                login.setEmail(resultado.getString("email"));
                login.setSenha(resultado.getString("senha"));
               
   
                resposta.add(login);
            }
        } catch (SQLException e) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return resposta;
    }
	 public boolean inserir(Login loginBd) {
	        String sql = "INSERT INTO login(email, senha) VALUES(?,?)";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, loginBd.getEmail());
	            stmt.setString(2, loginBd.getSenha());
	           
	            stmt.execute();
	            return true;
	        } catch (SQLException e) {
	            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, e);
	            return false;
	        }
	    }
	 public boolean alterar(Login login) {
	        String sql = "UPDATE login SET senha=? WHERE loginId=?";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, login.getSenha());
	            stmt.setInt(2, login.getLoginId());
	            
	            stmt.execute();
	            return true;
	        } catch (SQLException e) {
	            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, e);
	            return false;
	        }
	    }
	 public boolean remover(int loginId) {
	        String sql = "DELETE FROM login WHERE loginId=?";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, loginId);
	            stmt.execute();
	            return true;
	        } catch (SQLException e) {
	            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, e);
	            return false;
	        }
	    }
}











