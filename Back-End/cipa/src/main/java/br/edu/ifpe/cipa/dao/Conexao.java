package br.edu.ifpe.cipa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	private static Connection connection;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost/cipa";
	private static final String USUARIO = "root";
    private static final String SENHA = "";
    
	public static Connection getConexaoMySQL() {
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DATABASE_URL, USUARIO, SENHA);
		}
		catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, e);
		}
		return connection;
	}

}
