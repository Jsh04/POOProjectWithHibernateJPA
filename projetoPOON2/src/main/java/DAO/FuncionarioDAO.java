package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import Exception.LojaFerramentasException;
import factory.ConnectionFactory;
import modelo.funcionario.Funcionario;

public class FuncionarioDAO implements DAO {

	
	private EntityManager em;
	
	public FuncionarioDAO() {
		this.em = ConnectionFactory.Conectar();
	}
	
	public void Cadastrar(Object obj) {
		Funcionario f = (Funcionario) obj;
		this.em.getTransaction().begin();
		this.em.persist(f);
		this.em.getTransaction().commit();
	}

	public void Listar() {
		String jpql = "SELECT f FROM Funcionario f";
		List<Funcionario> list = this.em.createQuery(jpql, Funcionario.class).getResultList();
		System.out.println(list.toString());
	}

	public void Alterar(int matricula, String nome, Double salario) {
			this.em.getTransaction().begin();
			Funcionario funcionario = this.em.find(Funcionario.class, matricula);
			funcionario.setNome(nome);
			funcionario.setSalario(salario);
			this.em.persist(funcionario);
			this.em.getTransaction().commit();

		}
	
	public boolean ListaVaziaFuncionario() {
		String jpql = "SELECT f FROM Funcionario f";
		boolean empty = this.em.createQuery(jpql, Funcionario.class).getResultList().isEmpty();
		if(empty) {
			return true;
		}
		return false;
	}
	
	public void Deletar(int matricula) {
		this.em.getTransaction().begin();
		Funcionario funcionario = this.em.find(Funcionario.class, matricula);
		this.em.merge(funcionario);
		this.em.remove(funcionario);
		this.em.getTransaction().commit();
		this.em.close();	
		}
	
	public Funcionario pegaFuncionario(int matricula) {
	 	Funcionario funcionario = this.em.find(Funcionario.class, matricula);
	 	if(funcionario != null) {
	 		return funcionario;
	 	}
	 	throw new LojaFerramentasException("Não existe esse funcionário");
	}
}
