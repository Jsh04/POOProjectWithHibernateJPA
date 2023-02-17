package controller;

import DAO.NotaFiscalDAO;
import modelo.notafiscal.NotaFiscal;

public class NotaFiscalController {
	
	private NotaFiscalDAO nDAO;

	public NotaFiscalController() {
		this.nDAO = new NotaFiscalDAO();
	}
	
	public void CadastrarNotaFiscal(NotaFiscal nf) {
		nDAO.Cadastrar(nf);
	}
	
	public void ListarNotaFiscal() {
		nDAO.Listar();
	}
	
	public void DeletarNotaFiscal(int numero) {
		nDAO.Deletar(numero);
	}
	
	
}
