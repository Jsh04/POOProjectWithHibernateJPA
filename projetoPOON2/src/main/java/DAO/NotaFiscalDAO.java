package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import factory.ConnectionFactory;
import modelo.notafiscal.NotaFiscal;

public class NotaFiscalDAO implements DAO {
	
	private EntityManager em;
	
	public NotaFiscalDAO() {
		this.em = ConnectionFactory.Conectar();
	}
	
	@Override
	public void Cadastrar(Object obj) {
		NotaFiscal nf = (NotaFiscal) obj;
		this.em.getTransaction().begin();
		this.em.persist(nf);
		this.em.getTransaction().commit();
	}

	@Override
	public void Listar() {
		String jpql = "SELECT NF FROM NotaFiscal NF";
		List<NotaFiscal> resultList = this.em.createQuery(jpql, NotaFiscal.class).getResultList();
		System.out.println(resultList.toString());
	}

	@Override
	public void Deletar(int numero) {
		this.em.merge(NotaFiscal.class);
		NotaFiscal nf = this.em.find(NotaFiscal.class, numero);
		this.em.remove(nf);
		
	}
	}


