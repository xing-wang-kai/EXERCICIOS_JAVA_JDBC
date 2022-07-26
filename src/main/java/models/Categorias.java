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
	public void listar() {
		Categorias.categorias.stream().forEach(ct -> System.out.println(ct));
	}
	
	public void listarPorId(Integer id) {
		Categorias.categorias.stream().forEach(ct->{
			if(ct.getId()==id) {
				System.out.println(ct);
			}
		});
	}
}
