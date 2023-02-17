package DAO;
import java.util.List;

import javax.persistence.EntityManager;

import Exception.LojaFerramentasException;
import factory.ConnectionFactory;
import modelo.produto.Produto;

public class ProdutoDAO implements DAO {
	
	private EntityManager em;

	public ProdutoDAO() {
		this.em = ConnectionFactory.Conectar();
	}

	public void Cadastrar(Object obj) {
		Produto p = (Produto) obj;
		this.em.getTransaction().begin();
		this.em.persist(p);
		this.em.getTransaction().commit();
	}
	
	public void Listar() {
		String jpql = "SELECT p FROM Produto p";
		List<Produto> resultList = this.em.createQuery(jpql, Produto.class).getResultList();
		System.out.println(resultList.toString());
	}

	public void AlteraProduto(int id, String nomeEditado, Double precoEditado) {
		Produto produto = this.em.find(Produto.class, id);
		this.em.merge(produto);
		produto.setNomeFerramenta(nomeEditado);
		produto.setPreco(precoEditado);
		this.em.persist(produto);
	}
	
	public void Deletar(int id) {
		this.em.getTransaction().begin();
		Produto produto = this.em.find(Produto.class, id);
		this.em.remove(produto);
		this.em.getTransaction().commit();
	}

	public Produto pegaProduto(int codProduto) {
			String jpql = "SELECT p FROM Produto p WHERE p.id = :codProduto";
			Produto produto = this.em.createQuery(jpql, Produto.class).setParameter("codProduto", codProduto).getSingleResult();
			if(produto != null) {
				return produto;
			}
		throw new LojaFerramentasException("Não existe esse produto!");
	}
	
}

	

