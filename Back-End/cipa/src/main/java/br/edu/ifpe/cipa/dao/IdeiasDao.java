package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import br.edu.ifpe.cipa.model.ConexaoMysql;
import br.edu.ifpe.cipa.model.Ideias;

public class IdeiasDao {
	private Connection connection;
		
		 
		 public boolean inserir(Ideias ideia) {
		        String sql = "INSERT INTO ideias(id_ideias, id_Lider, temas_impactados, reseumo_do_projeto, video_demostrativo, nota, id_concurso) VALUES(?,?,?,?,?,?,?)";
		        try {
		            PreparedStatement stmt = ( connection).prepareStatement(sql);
		            stmt.setInt(1, ideia.getIdIdeias());
		            stmt.setInt(2, ideia.getIdConcurso());
		            stmt.setInt(3, ideia.getIdLider());
		            stmt.setString(4, ideia.getTemasImpactados());
		            stmt.setString(5, ideia.getResumoDoProjeto());
		            stmt.setString(6, ideia.getVideoDemostrativo());
		            stmt.setFloat(7, ideia.getNota());
		           
		            return true;
		        } catch (SQLException ex) {
		            Logger.getLogger(IdeiasDao.class.getName()).log(null);
		            return false;
		        }
		    }
		 
		 public void consultar(Ideias ideias) throws ClassNotFoundException, SQLException{
				Connection connection = (Connection) ConexaoMysql.getConexaoMySQL();
				String sql = "INSERT INTO 'ideias'"
						+ "('id_concurso','id_ideias','id_lider','nota','resumo_do_projeto','temas_impactados','video_demostrativo')"
						+ "VALUES (? , ?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = (PreparedStatement) ((java.sql.Connection) connection).prepareStatement(sql);
				
				stmt.setInt(1, ideias.getIdIdeias());
				stmt.setInt(2, ideias.getIdLider());
				stmt.setInt(3, ideias.getIdConcurso());
				stmt.setString(4, ideias.getTemasImpactados());
				stmt.setString(5, ideias.getResumoDoProjeto());
				stmt.setString(6, ideias.getVideoDemostrativo());
				stmt.setFloat(7, ideias.getNota());
				
				stmt.execute();
				stmt.close();
				connection.close();
		}

		public List<Ideias> listar() {
			return null;
		}
}
