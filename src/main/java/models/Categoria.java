package models;

import java.util.Locale;

public class Categoria {
	private int id;
	private String nome;

	public Integer getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format(new Locale("pt", "br"), "{ CATEGORIA ID: %d , NOME: %s", this.id, this.nome);
	}

}
