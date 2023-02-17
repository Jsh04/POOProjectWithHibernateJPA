package controller;

import DAO.ClienteDAO;
import modelo.cliente.Cliente;

public class ClienteController {
	
	private ClienteDAO cDAO;
	
	public ClienteController() {
		this.cDAO = new ClienteDAO();
	}
	
	public void CadastrarCliente(Cliente c) {
		cDAO.Cadastrar(c);
	}
	public void ListarCliente() {
		cDAO.Listar();
	}
	
	public void AlterarCliente(int id, char escolha, String nomeCliente, String email, String endereco, String bairro,
			String estado, String telefone) {
		cDAO.Alterar(id, escolha, nomeCliente, email, endereco, bairro, estado, telefone);
	}
	public void DeletarCliente(int id) {
		cDAO.Deletar(id);
	}
	
	public Cliente ProcuraCPF(String cpf) {
		return cDAO.ProcuraCPF(cpf);
	}
	
	public Cliente ProcuraCNPJ(String cnpj) {
		return cDAO.ProcuraCNPJ(cnpj);
	}
}
