package com.silvio.modelo.cliente;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente_Jur�dico")
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
