package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connection.ConnectionFactory;
import models.Categoria;

public class CategoriasDao {
	public ArrayList<Categoria> listar() {
		ArrayList<Categoria> categorias = new ArrayList<>();
		try(Connection con = new ConnectionFactory().connect()){
			String query = "SELECT * FROM categorias;";
			try(PreparedStatement stm = con.prepareStatement(query)){
				stm.execute();
				try(ResultSet rs = stm.getResultSet()){
					while(rs.next()) {
						Categoria categoria = new Categoria(rs.getInt("id"), rs.getString("nome"));
						categorias.add(categoria);
					}
				}
			}
		}catch(Exception e) {
			System.out.println("OCORREU UM ERROR EM LISTAR CATEGORIAS DAO: " + e.getStackTrace());
		}
		return categorias;
	}
}
