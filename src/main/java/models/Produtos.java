package models;

import java.util.ArrayList;
import java.util.List;

public class Produtos {
	public static List<Produto> produtos = new ArrayList<>();

	public void adicionar(Produto valor) {
		Produtos.produtos.add(valor);
	}

	public void remover(Integer id) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				produtos.remove(produto);
			}
		}
	}
	public void litar(){
		produtos.forEach(p -> System.out.println(p));
	}
}
