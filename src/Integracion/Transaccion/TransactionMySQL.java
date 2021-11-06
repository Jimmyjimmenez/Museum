package src.Integracion.Transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionMySQL implements Transaction {
	
	private Connection connection;
	
	private final String username = "museoms";
	private final String password = "password";
	private final String url = "jdbc:mysql://haidoni-dev.dns.army:3306";

	public void start() {
		try {
			connection = DriverManager.getConnection(url,username, password);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commit() {
		try{
			connection.commit();
			connection.close();
			TransactionManager.getInstancia().eliminaTransaccion();
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	}

	public void rollback() {
		try{
			connection.rollback();
			connection.close();
			TransactionManager.getInstancia().eliminaTransaccion();
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
	}

	public Connection getResource() {
		return connection;
	}
}
