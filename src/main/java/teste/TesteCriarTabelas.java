package teste;

import java.math.BigDecimal;
//import java.math.BigDecimal;
import java.sql.SQLException;

import Connection.ConnectionFactory;
import dao.ProdutosDao;
import models.Produto;
//import models.Produto;
import models.Produtos;

public class TesteCriarTabelas {
	public static void main(String[] args) throws SQLException {

		//ConnectionFactory factory = new ConnectionFactory();
		//factory.createTable();

		Produto celular = new Produto("Nexus furadeira", "Furadeira tipo nexus", new BigDecimal(200.00), 1);
		Produto mesa = new Produto("Mesa Comex", "mesa de madeira Comex", new BigDecimal(2000.00), 3);
		Produto geladeira = new Produto("Geladeira Duplex", "geladeira frost free duplex", new BigDecimal(3000.00), 2);
		//Produto cama = new Produto("Cama de Casal", "cama de casal florentine", new BigDecimal(2000.00), 4);

		ProdutosDao Query = new ProdutosDao();

		Query.create(celular);
		Query.create(mesa);
		Query.create(geladeira);
		//Query.create(cama);

		// Query.editar(celular, 2);
		Query.listar();

		Produtos produtos = new Produtos();

		produtos.litar();

		Query.remover(1);

		// produtos.litar();

	}
}
