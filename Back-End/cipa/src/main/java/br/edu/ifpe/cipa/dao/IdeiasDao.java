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
		String sql = "INSERT INTO ideias( id_lider, id_concurso,imagem, resumo_do_projeto, temas_impactados, video_demostrativo, nota) VALUES (?,?,?,?,?,?,?)";

		try {
			PreparedStatement stmt = (connection).prepareStatement(sql);

			stmt.setString(1, ideia.getId_lider());
			stmt.setInt(2, ideia.getId_concurso());
			stmt.setString(3, ideia.getImagem());
			stmt.setString(4, ideia.getResumo_do_projeto());
			stmt.setString(5, ideia.getTemas_Impactados());
			stmt.setString(6, ideia.getVideo_demostrativo());
			stmt.setFloat(7, ideia.getNota());
			stmt.setString(8, ideia.getNome());

			stmt.execute();
			stmt.close();
			connection.close();

			return true;
		} catch (SQLException ex) {
			Logger.getLogger(IdeiasDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
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
				cliente.setId_ideia(resultado.getInt("Id_Ideia"));
				cliente.setId_lider(resultado.getString("Id_Lider"));
				cliente.setImagem(resultado.getString("imagem"));
				cliente.setId_concurso(resultado.getInt("Id_Concurso"));
				cliente.setTemas_Impactados(resultado.getString("Temas_Impactados"));
				cliente.setResumo_do_projeto(resultado.getString("Resumo_Do_Projeto"));
				cliente.setVideo_demostrativo(resultado.getString("Video_Demostrativo"));
				cliente.setNota(resultado.getFloat("Nota"));
				cliente.setNome(resultado.getString("nome"));

				retorno.add(cliente);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return retorno;
	}

	public boolean Deletar(Integer id) {
		String sql = "DELETE FROM ideias WHERE id_ideia=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(IdeiasDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

	public boolean Atualizar(Ideias ideias) {
		String sql = "UPDATE ideias SET id_concurso=?, id_lider=?,imagem=?, nota=? , resumo_do_projeto=? , temas_impactados=? ,video_demostrativo=? WHERE id_ideias=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, ideias.getId_concurso());
			stmt.setInt(2, ideias.getId_ideia());
			stmt.setString(3, ideias.getId_lider());
			stmt.setString(4, ideias.getImagem());
			stmt.setFloat(5, ideias.getNota());
			stmt.setString(6, ideias.getResumo_do_projeto());
			stmt.setString(7, ideias.getTemas_Impactados());
			stmt.setString(8, ideias.getVideo_demostrativo());

			stmt.execute();
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(IdeiasDao.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}

}
