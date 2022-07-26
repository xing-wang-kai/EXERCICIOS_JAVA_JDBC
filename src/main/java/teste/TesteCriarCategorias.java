package teste;

import java.util.ArrayList;

import dao.CategoriasDao;
import models.Categoria;
import models.Categorias;

public class TesteCriarCategorias {
	public static void main(String[] args) {
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
