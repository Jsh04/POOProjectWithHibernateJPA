package modelo.funcionario;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
