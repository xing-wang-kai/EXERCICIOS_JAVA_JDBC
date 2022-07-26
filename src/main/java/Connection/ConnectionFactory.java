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
			
			String query2 = "CREATE TABLE IF NOT EXISTS categorias ("
					+ "id int AUTO_INCREMENT NOT NULL,"
					+ "nome varchar(255) NOT NULL,"
					+ "PRIMARY KEY(ID)"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;";
//			
//			String query3 = "ALTER TABLE produtos add COLUMN categoria_id int";
//			String query4 = "ALTER TABLE produtos add FOREIGN KEY(categoria_id) REFERENCES categorias (id)";
//			
			com.setAutoCommit(false);
			PreparedStatement stm = this.com.prepareStatement(query);
			PreparedStatement stm2 = this.com.prepareStatement(query2);
//			PreparedStatement stm3 = this.com.prepareStatement(query3);
//			PreparedStatement stm4 = this.com.prepareStatement(query4);
			
			
			stm.execute();
			stm2.execute();
//			stm3.execute();
//			stm4.execute();
			
			ResultSet rs = stm.getResultSet();
			ResultSet rs2 = stm2.getResultSet();
//			ResultSet rs3 = stm3.getResultSet();
//			ResultSet rs4 = stm4.getResultSet();
			
			System.out.println("TABELA PRODUTOS COM SUCESSO!" + rs);
			System.out.println("TABELA CATEGORIAS COM SUCESSO!" + rs2);
//			System.out.println("TABELA CATEGORIAS COM SUCESSO!" + rs3);
//			System.out.println("TABELA CATEGORIAS COM SUCESSO!" + rs4);
			
			com.commit();
			
			stm.close();
			stm2.close();
//			stm3.close();
//			stm4.close();
//			
			com.close();
			
		} catch (Exception e) {
			System.out.println("OCORREU ERRO: " + e);
		}
	}
}
