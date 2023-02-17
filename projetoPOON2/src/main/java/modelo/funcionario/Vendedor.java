package modelo.funcionario;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
