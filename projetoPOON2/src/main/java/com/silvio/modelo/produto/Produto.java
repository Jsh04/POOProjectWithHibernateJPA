package com.silvio.modelo.produto;


import com.silvio.modelo.categoria.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto implements Desconto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_Produto")
	private int id;
	
	@Column(name= "nome")
	private String nomeFerramenta;
	private Double preco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NOME_CATEGORIA")
	private Categoria categoria;
	
	public Produto() {
	}
	
	public Produto(String nomeFerramenta, Double preco, Categoria categoria) {
		this.nomeFerramenta = nomeFerramenta;
		this.preco = preco;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}


	public String getNomeFerramenta() {
		return nomeFerramenta;
	}

	public void setNomeFerramenta(String nomeFerramenta) {
		this.nomeFerramenta = nomeFerramenta;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void DescontoAplicado(Double desconto) {
		this.preco = this.preco - (desconto / 100 * this.preco);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("C�digo: " + id)
		.append("Nome da ferramenta: " + this.nomeFerramenta)
		.append(" Pre�o: " + this.preco);
		return sb.toString();
	}

	
	

}
