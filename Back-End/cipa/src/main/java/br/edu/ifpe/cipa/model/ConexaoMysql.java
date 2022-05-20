package br.edu.ifpe.cipa.model;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class ConexaoMysql {
	public static Connection getConexaoMySQL() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/cipa","root","");
		return connection;
	}
	public static void main(String[] args) {
		try {
			try {
				ConexaoMysql.getConexaoMySQL();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch ( ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

}
