package models;

import java.util.ArrayList;
import java.util.List;

public class Categorias {
	public static List<Categoria> categorias = new ArrayList<>();
	
	public Categorias() {
		
	}
	public void adicionar(Categoria categoria) {
		Categorias.categorias.add(categoria);
	}
	public void deletar(Integer id) {
		Categorias.categorias.stream().forEach(ct->{
			if(ct.getId()==id) {
				categorias.remove(ct);
			}
		});
	}
	public ArrayList<Categoria> listar() {
		ArrayList<Categoria> ctg = new ArrayList<>();
		Categorias.categorias.stream().forEach(ct -> {
			ctg.add(ct);
		});
		return ctg;
	}
	
	public void listarPorId(Integer id) {
		Categorias.categorias.stream().forEach(ct->{
			if(ct.getId()==id) {
				System.out.println(ct);
			}
		});
	}
	public void listarCategoriasEProdutos() {
		Categorias.categorias.stream().forEach(ct->{
			System.out.println("Valor: " + ct);
			ArrayList<Produto> ptd = new ArrayList<>();
			for(Produto pdt: new Produtos().litar(ct)){
				ptd.add(pdt);
				System.out.println("produto add");
			}
			ptd.stream().forEach(p->{
				System.out.println(p);
			});
		});
	}
}
