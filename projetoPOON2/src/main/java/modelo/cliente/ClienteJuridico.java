package modelo.cliente;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente_Jurídico")
@PrimaryKeyJoinColumn(name = "id")
public class ClienteJuridico extends Cliente{
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "TEL_EMPRESARIAL")
	private String telefoneComecial;
	
	public ClienteJuridico() {
	}
	
	public ClienteJuridico( String nome, String email, LocalDate dataNascimento, String endereco, String bairro,String cidade, String estado, String cnpj, String telefoneComecial) {
		super(nome, email, dataNascimento, endereco, bairro,estado, cidade);
		this.cnpj = cnpj;
		this.telefoneComecial = telefoneComecial;
	}
	
	public String getTelefoneComecial() {
		return telefoneComecial;
	}
	public void setTelefoneComecial(String telefoneComecial) {
		this.telefoneComecial = telefoneComecial;
	}
	public String getCnpj() {
		return cnpj;
	}
	
	
	
	
}
