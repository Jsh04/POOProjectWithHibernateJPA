package modelo.notafiscal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.cliente.Cliente;
import modelo.funcionario.Funcionario;
import modelo.itensprodutos.ItensProduto;
@Entity
@Table(name="Nota_Fiscal")
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero = 0;
	
	private LocalDateTime data = LocalDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matricula")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy = "nf", cascade = CascadeType.ALL)
	private List<ItensProduto> list = new ArrayList<>();
	
	public NotaFiscal() {
	}
	
	public NotaFiscal(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.cliente = null;
	}
	
	public NotaFiscal(Cliente cliente, Funcionario funcionario ) {
		this(funcionario);
		this.cliente = cliente;
	}
	
	public void CadastrarItensProdutos(ItensProduto it) {
		it.setNf(this);
		list.add(it);
	}

	public int getNumero() {
		return numero;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItensProduto> getList() {
		return list;
	}

	public void setList(List<ItensProduto> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb
		.append("Número: ")
		.append(this.numero)
		.append("\n")
		.append("Data: ")
		.append(this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
		.append("\n")
		.append("Vendedor: ")
		.append(this.funcionario.getNome())
		.append("\n");
		if(this.cliente != null) {
			sb.append("Cliente: ")
			.append(", " + this.cliente)
			.append("\n");
		}
		sb.append("Valor: ");
		for (ItensProduto ip : list) {
			double sum = 0;
			sum += ip.Valor();
			sb.append(sum);
		}
		return sb.toString();
	}
	
	
	
	
	
}
