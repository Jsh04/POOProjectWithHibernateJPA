package modelo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public enum Categoria{

	 ELETRICO("ELETRICO"),
	 MANUAIS("MANUAIS"), 
	 BASICAS("BASICAS");
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String categoria;
	
	Categoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	@Override
	public String toString() {
		return "Categoria: " + this.getCategoria();
	}
	
}
