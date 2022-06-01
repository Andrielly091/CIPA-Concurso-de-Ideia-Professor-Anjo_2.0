package br.edu.ifpe.cipa.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.ifpe.cipa.model.Email;

public class EmailDao {
	
	private Connection connection;
	
	 public boolean inserir(Email emailBd) throws ClassNotFoundException, SQLException {
			
	        String sql = "INSERT INTO Email(email) VALUES(?,?)";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, emailBd.getEmail());
	           
	            stmt.execute();
				stmt.close();
	            return true;
	        } catch (SQLException e) {
	            Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, e);
	            
	            return false;
	        }}
	        
	        public boolean alterar(Email email) throws ClassNotFoundException, SQLException {
	        	
		        String sql = "UPDATE Email SET senha=? WHERE idMail=?";
		        try {
		            PreparedStatement stmt = connection.prepareStatement(sql);
		            stmt.setString(1, email.getSenha());
		            stmt.setInt(2, email.getIdMail());
		            
		            stmt.execute();
					stmt.close();
		            return true;
		        } catch (SQLException e) {
		            Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, e);
		            return false;
		        }}
		    
		        public boolean remover(int idMail) throws ClassNotFoundException, SQLException {
		    		
			        String sql = "DELETE FROM Email WHERE idMail=?";
			        try {
			            PreparedStatement stmt = connection.prepareStatement(sql);
			            stmt.setInt(1, idMail);
			        
			            stmt.execute();
						stmt.close();
			            return true;
			        } catch (SQLException e) {
			            Logger.getLogger(EmailDao.class.getName()).log(Level.SEVERE, null, e);
			          
			            return false;
			        }
			    }

				}


