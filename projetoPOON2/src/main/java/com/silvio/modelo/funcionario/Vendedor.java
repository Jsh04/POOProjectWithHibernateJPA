package com.silvio.modelo.funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vendedor")
@PrimaryKeyJoinColumn(name = "matricula")
public class Vendedor extends Funcionario{

	public Vendedor() {
		super();
	}

	public Vendedor(String nome, Double salario) {
		super(nome, salario + 20);

	}

}
