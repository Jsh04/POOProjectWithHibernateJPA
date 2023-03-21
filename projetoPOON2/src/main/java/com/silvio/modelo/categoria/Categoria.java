package com.silvio.modelo.categoria;



public enum Categoria{

	 ELETRICO("ELETRICO"),
	 MANUAIS("MANUAIS"), 
	 BASICAS("BASICAS");

	
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
