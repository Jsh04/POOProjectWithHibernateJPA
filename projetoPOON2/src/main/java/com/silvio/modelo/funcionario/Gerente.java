package com.silvio.modelo.funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gerente")
@PrimaryKeyJoinColumn(name = "matricula")
public class Gerente extends Funcionario {
	
	public Gerente() {
		super();
	}

	public Gerente(String nome, Double salario) {
		super(nome, salario + 200);
	}


}
