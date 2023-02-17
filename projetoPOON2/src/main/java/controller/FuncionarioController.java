package controller;

import DAO.FuncionarioDAO;
import Exception.LojaFerramentasException;
import modelo.funcionario.Funcionario;

public class FuncionarioController {
	private FuncionarioDAO fDAO; 
	
	public FuncionarioController() {
		
		this.fDAO = new FuncionarioDAO();
	}
	
	public void CadastrarFuncionario(Funcionario f) {
		fDAO.Cadastrar(f);
	}
	public void ListarFuncionario() {
		fDAO.Listar();
	}
	
	public boolean ListaVaziaFuncionario() {
		if(fDAO.ListaVaziaFuncionario()) {
			throw new LojaFerramentasException("É necessário cadastrar Funcionário para fazer pedido");
		}
		return true;
	}
	
	public void AlterarFuncionario(int matricula, String nome , Double salario) {
		fDAO.Alterar(matricula,nome,salario);
	}
	public void DeletarFuncionario(int id) {
		fDAO.Deletar(id);
	}
	
	public Funcionario pegaFuncionario(int numero) {
		return fDAO.pegaFuncionario(numero);
	}
	
}
