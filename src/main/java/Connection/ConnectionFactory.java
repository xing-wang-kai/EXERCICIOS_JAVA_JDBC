package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection com;

	public ConnectionFactory() throws SQLException {
		this.connect();
	}

	public Connection connect() throws SQLException {
		this.com = DriverManager.getConnection("jdbc:mysql://localhost:3308/loja", "root", "hoot");
		return com;
	}

	public void createTable() {
		try {
			String query = "CREATE TABLE IF NOT EXISTS produtos("
					+ "id int AUTO_INCREMENT NOT NULL, "
					+ "nome varchar(255), "
					+ "descricao varchar(255), "
					+ "preco decimal,"
					+ "PRIMARY KEY(id)"
					+ ")ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;";
			com.setAutoCommit(false);
			PreparedStatement stm = this.com.prepareStatement(query);
			
			stm.execute();
			ResultSet rs = stm.getResultSet();
			System.out.println("TABELA CRIADA COM SUCESSO!" + rs);
			
			com.commit();
			stm.close();
			com.close();
			
		} catch (Exception e) {
			System.out.println("OCORREU ERRO: " + e);
		}
	}
}
