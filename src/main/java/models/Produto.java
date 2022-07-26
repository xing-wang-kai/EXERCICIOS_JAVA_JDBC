package models;

import java.math.BigDecimal;
import java.util.Locale;

public class Produto {
	private Integer id;
	private String nome;
	private BigDecimal valor;
	private String descricao;
	private Integer categoria;
	
	public Produto(String nome, String descricao, BigDecimal valor, int categoria) {
		this.setNome(nome);
		this.setValor(valor);
		this.setDescricao(descricao);
		this.setCategoria(categoria);
		System.out.println("novo objecto criado com suscesso");
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer valor) {
		this.id = valor;
	}
	public void setNome(String valor) {
		this.nome = valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public void setDescricao(String valor)
	{
		this.descricao = valor;
	}

	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "{ nome: %s, descrição: %s, valor: %.2f }", this.nome,
				this.descricao, this.valor);
	}
	public String getNome() {
		return this.nome;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public BigDecimal getValor() {
		return this.valor;
	}
	public int getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Integer valor) {
		this.categoria = valor;
	}
}
