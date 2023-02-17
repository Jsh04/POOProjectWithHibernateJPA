package modelo.produto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import modelo.categoria.Categoria;

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
		sb.append("Código: " + id)
		.append("Nome da ferramenta: " + this.nomeFerramenta)
		.append(" Preço: " + this.preco);
		return sb.toString();
	}

	
	

}
