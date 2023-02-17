package controller;


import DAO.ProdutoDAO;
import modelo.produto.Produto;

public class ProdutoController {
private ProdutoDAO pDAO;
	
	public ProdutoController() {
		this.pDAO = new ProdutoDAO();
	}
	
	public void CadastrarProduto(Produto p) {
		pDAO.Cadastrar(p);
	}
	public void ListarProduto() {
		pDAO.Listar();
	}
	
	public void AlterarProduto(int id, String nomeEditado, Double precoEditado) {
		pDAO.AlteraProduto(id, nomeEditado, precoEditado);;
	}
	public void DeletarProduto(int id) {
		pDAO.Deletar(id);
	}
	
	public Produto pegaProduto(int codProduto) {
		return pDAO.pegaProduto(codProduto);
	}
}
