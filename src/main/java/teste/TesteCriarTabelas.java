package teste;

//import java.math.BigDecimal;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import dao.ProdutosDao;
//import models.Produto;
import models.Produtos;

public class TesteCriarTabelas {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.createTable();
		
		//Produto celular = new Produto("Nexus furadeira", "Furadeira tipo nexus", new BigDecimal(200.00));
		ProdutosDao Query = new ProdutosDao();
		
		//Query.create(celular);
		//Query.editar(celular, 2);
		Query.listar();
		
		Produtos produtos = new Produtos();
		
		produtos.litar();
		
		Query.remover(2);
		
		produtos.litar();
		
	}	
}
