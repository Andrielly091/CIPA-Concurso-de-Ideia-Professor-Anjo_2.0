package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.edu.ifpe.cipa.model.Ideias;

public class IdeiasDao {
	private Connection connection;

		 public boolean inserir(Ideias ideia) throws ClassNotFoundException, SQLException {
		        String sql = "INSERT INTO ideias( id_lider, temas_impactados, resumo_do_projeto, video_demostrativo, nota, id_concurso) VALUES (?,?,?,?,?,?)";
		        try {
		            PreparedStatement stmt = ( connection).prepareStatement(sql);
		            
		            stmt.setString(1, ideia.getIdLider());
		            stmt.setInt(6, ideia.getIdConcurso());
					stmt.setString(3, ideia.getResumoDoProjeto());
					stmt.setString(2, ideia.getTemasImpactados());
					stmt.setString(4, ideia.getVideoDemostrativo());
					stmt.setFloat(5, ideia.getNota());
					
					stmt.execute();
					stmt.close();
					connection.close();
					
		            return true;
		        } catch (SQLException ex) {
		            Logger.getLogger(IdeiasDao.class.getName()).log(Level.SEVERE,null,ex);
		            return false;
		        }
		    }
		 
		 public void consultar(Ideias ideias) throws ClassNotFoundException, SQLException{
			
				String sql = "INSERT INTO 'ideias'"
						+ "('id_concurso','id_ideias','id_lider','nota','resumo_do_projeto','temas_impactados','video_demostrativo')"
						+ "VALUES (? , ?, ?, ?, ?, ?, ?)";
				PreparedStatement stmt = (PreparedStatement) ((java.sql.Connection) connection).prepareStatement(sql);
				
				stmt.setInt(1, ideias.getIdIdeias());
				stmt.setString(2, ideias.getIdLider());
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
			String sql = "SELECT * FROM ideias";
	        List<Ideias> retorno = new ArrayList<>();
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            ResultSet resultado = stmt.executeQuery();
	            while (resultado.next()) {
	                Ideias cliente = new Ideias();
	                cliente.setIdIdeias(resultado.getInt("IdIdeias"));
	                cliente.setIdLider(resultado.getString("IdLider"));
	                cliente.setIdConcurso(resultado.getInt("IdConcurso"));
	                cliente.setTemasImpactados(resultado.getString("TemasImpactados"));
	                cliente.setResumoDoProjeto(resultado.getString("ResumoDoProjeto"));
	                cliente.setVideoDemostrativo(resultado.getString("VideoDemostrativo"));
	                cliente.setNota(resultado.getFloat("Nota"));
	            
	                retorno.add(cliente);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return retorno;
		}
		
}
