package modelo.funcionario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import Exception.LojaFerramentasException;

@Entity
@Table(name = "Funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula;
	private String nome;
	private Double salario;
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, Double salario) {
		if(nome == null) {
			throw new LojaFerramentasException("N„o pode entrar com o nome vazio!");
		}
		this.nome = nome;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Matr√≠cula: " + matricula)
		.append(", Nome: " + this.nome);
		return sb.toString();
	}


}
