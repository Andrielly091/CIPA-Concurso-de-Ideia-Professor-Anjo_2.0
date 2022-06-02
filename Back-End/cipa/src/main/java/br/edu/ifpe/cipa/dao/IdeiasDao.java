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
	Connection connection = Conexao.getConexaoMySQL();

		 public boolean inserir(Ideias ideia) throws ClassNotFoundException, SQLException {
		        String sql = "INSERT INTO ideias( id_lider, temas_impactados, resumo_do_projeto, video_demostrativo, nota, id_concurso) VALUES (?,?,?,?,?,?)";

		        try {
		            PreparedStatement stmt = ( connection).prepareStatement(sql);
		            
		            stmt.setString(1, ideia.getId_lider());
		            stmt.setInt(6, ideia.getId_concurso());
					stmt.setString(3, ideia.getResumo_do_projeto());
					stmt.setString(2, ideia.getTemas_Impactados());
					stmt.setString(4, ideia.getVideo_demostrativo());
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
				
				stmt.setInt(1, ideias.getId_ideias());
				stmt.setString(2, ideias.getId_lider());
				stmt.setInt(3, ideias.getId_concurso());
				stmt.setString(4, ideias.getTemas_Impactados());
				stmt.setString(5, ideias.getResumo_do_projeto());
				stmt.setString(6, ideias.getVideo_demostrativo());
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
	                System.out.println(cliente);
	                cliente.setId_ideias(resultado.getInt("Id_Ideias"));
	                cliente.setId_lider(resultado.getString("Id_Lider"));
	                cliente.setId_concurso(resultado.getInt("Id_Concurso"));
	                cliente.setTemas_Impactados(resultado.getString("Temas_Impactados"));
	                cliente.setResumo_do_projeto(resultado.getString("Resumo_Do_Projeto"));
	                cliente.setVideo_demostrativo(resultado.getString("Video_Demostrativo"));
	                cliente.setNota(resultado.getFloat("Nota"));
	            
	                retorno.add(cliente);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return retorno;
		}
		
}
