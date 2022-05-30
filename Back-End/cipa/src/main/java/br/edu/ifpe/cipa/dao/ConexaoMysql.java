package br.edu.ifpe.cipa.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class ConexaoMysql {
	public static Connection getConexaoMySQL() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cipa","root","");
		return connection;
	}
}
