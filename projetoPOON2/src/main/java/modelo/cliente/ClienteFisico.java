package modelo.cliente;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente_Físico")
@PrimaryKeyJoinColumn(name = "id")
public class ClienteFisico extends Cliente {
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "Tel_Pessoal")
	private String telefonePessoal;
	
	public ClienteFisico() {
	}
	
	public ClienteFisico(String nome, String email, LocalDate dataNascimento, String endereco, String bairro, String estado, String cidade, String cpf, String telefonePessoal) {
		super(nome, email, dataNascimento, endereco, bairro, estado, cidade);
		this.cpf = cpf;
		this.telefonePessoal = telefonePessoal;
	}

	public String getTelefonePessoal() {
		return telefonePessoal;
	}

	public void setTelefonePessoal(String telefonePessoal) {
		this.telefonePessoal = telefonePessoal;
	}

	public String getCpf() {
		return cpf;
	}
	
	

	
}
