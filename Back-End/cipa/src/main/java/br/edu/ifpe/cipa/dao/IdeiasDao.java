package br.edu.ifpe.cipa.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.jdi.connect.spi.Connection;

import br.edu.ifpe.cipa.model.Ideias;

public class IdeiasDao {
	private Connection connection;
	
	 public IdeiasDao() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            String DATABASE_URL = "jdbc:mysql://localhost/cipa";
	            String usuario = "root";
	            String senha = "";
	            this.connection = (Connection) DriverManager.getConnection(DATABASE_URL, usuario, senha);
	        } catch (ClassNotFoundException | SQLException ex) {
	            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	 
	 public boolean inserir(Ideias ideia) {
	        String sql = "INSERT INTO ideias(id_ideias, id_Lider, temas_impactados, reseumo_do_projeto, video_demostrativo, nota, id_concurso) VALUES(?,?,?,?,?,?,?)";
	        try {
	            PreparedStatement stmt = ((java.sql.Connection) connection).prepareStatement(sql);
	            stmt.setInt(1, ideia.getIdIdeias());
	            stmt.setInt(2, ideia.getIdConcurso());
	            stmt.setInt(3, ideia.getIdLider());
	            stmt.setString(4, ideia.getTemasImpactados());
	            stmt.setString(5, ideia.getResumoDoProjeto());
	            stmt.setString(6, ideia.getVideoDemostrativo());
	            stmt.setFloat(7, ideia.getNota());
	           
	            return true;
	        } catch (SQLException ex) {
	            Logger.getLogger(IdeiasDao.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }

	public List<Ideias> listar() {
		return null;
	}
}
