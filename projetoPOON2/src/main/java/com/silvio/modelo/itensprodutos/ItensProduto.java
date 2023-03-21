package com.silvio.modelo.itensprodutos;

import com.silvio.modelo.notafiscal.NotaFiscal;
import com.silvio.modelo.produto.Produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name="Itens_Produto")
public class ItensProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod_itens")
	private int id;
	
	@Column(name = "Quantidade")
	private int qtd;
	
	@OneToOne
	@JoinColumn(name = "COD_Produto")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "numero")
	private NotaFiscal nf;



	public ItensProduto(int qtd, Produto produto, NotaFiscal nf) {
		this.qtd = qtd;
		this.produto = produto;
		this.nf = nf;
	}
		
	public NotaFiscal getNf() {
		return nf;
	}

	public void setNf(NotaFiscal nf) {
		this.nf = nf;
	}


	public double Valor(){
		return produto.getPreco() * this.qtd;
	}
	
}
