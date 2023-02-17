package modelo.itensprodutos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.notafiscal.NotaFiscal;
import modelo.produto.Produto;

@Entity
@Table(name="Itens_Produto")
public class ItensProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "Quantidade")
	private int qtd;
	
	@OneToOne
	@JoinColumn(name = "COD_Produto")
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
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
