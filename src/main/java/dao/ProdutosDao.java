package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.ConnectionFactory;
import models.Produto;
import models.Produtos;

public class ProdutosDao {
	private Connection con;

	public ProdutosDao() throws SQLException {
		
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public void create(Produto produto) throws SQLException {
		this.setCon(new ConnectionFactory().connect());
		String query = "INSERT INTO produtos(nome, descricao, preco) values(?, ?, ?)";
		this.con.setAutoCommit(false);
		PreparedStatement stm = this.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		stm.setString(1, produto.getNome());
		stm.setString(2, produto.getDescricao());
		stm.setBigDecimal(3, produto.getValor());

		stm.execute();

		ResultSet rs = stm.getGeneratedKeys();
		while (rs.next()) {
			rs.getString(1);
		}
		this.con.commit();
		stm.close();
		this.con.close();

		System.out.println("PRODUTO INSERIDO COM SUCESSO: " + produto);
	}

	public void editar(Produto produto, Integer id) throws SQLException {
		this.setCon(new ConnectionFactory().connect());
		String query = "UPDATE produtos set nome=?, descricao=?, preco=? where(id=?);";
		try (PreparedStatement stm = this.con.prepareStatement(query)) {

			this.con.setAutoCommit(false);

			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setBigDecimal(3, produto.getValor());
			stm.setInt(4, id);

			stm.execute();

			Integer rs = stm.getUpdateCount();
			System.out.println("TOTAL DE EDICAO: " + rs);

			this.con.commit();
			this.con.close();

		} catch (Exception e) {
			System.out.println("OCORREU UM ERROR: " + e);
		}
	}

	public void listar() throws SQLException {
		this.setCon(new ConnectionFactory().connect());
		String query = "SELECT * FROM produtos";
		this.con.setAutoCommit(false);
		try (PreparedStatement stm = this.con.prepareStatement(query)) {
			stm.execute();
			
			ResultSet rs = stm.getResultSet();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getString("nome"), rs.getString("descricao"), rs.getBigDecimal("preco"));
				produto.setId(rs.getInt("id"));
				Produtos produtos = new Produtos();
				produtos.adicionar(produto);
				System.out.println("Produto Adciionado com sucesso ID: " + produto.getId());
			}
			
			con.commit();
			stm.close();
			con.close();
		} catch (Exception e) {
			System.out.println("OCORREU UM ERROR: " + e);
		}

	}
	public void remover(Integer id) throws SQLException{
		this.setCon(new ConnectionFactory().connect());
		String query = "DELETE FROM produtos Where (id = ?);";
		try(PreparedStatement stm = this.con.prepareStatement(query)){
			
			stm.setInt(1, id);
			stm.execute();
			int rs = stm.getUpdateCount();
			
			System.out.println("TOTAL DELETADOS: " + rs);
			
			new Produtos().remover(id);

			con.close();
		}catch(Exception e) {
			System.out.println("OCOREEU UM ERROR: " + e.getStackTrace());
		}
	}
}
