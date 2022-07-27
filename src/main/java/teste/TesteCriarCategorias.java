package teste;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CategoriasDao;
import dao.ProdutosDao;
import models.Categoria;
import models.Categorias;

public class TesteCriarCategorias {
	
	public static void main(String[] args) throws SQLException {
		
		ProdutosDao Query = new ProdutosDao();
		Query.listar();
		CategoriasDao cd = new CategoriasDao();
		ArrayList<Categoria> categorias = cd.listar();
		Categorias ctg = new Categorias();
		categorias.stream().forEach(ct->{
			ctg.adicionar(ct);
			System.out.println("ADICIONADO");
		});
		ctg.listarCategoriasEProdutos();
		
		
	}
}
