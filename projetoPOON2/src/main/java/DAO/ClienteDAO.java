package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import Exception.LojaFerramentasException;
import factory.ConnectionFactory;
import modelo.cliente.Cliente;
import modelo.cliente.ClienteFisico;
import modelo.cliente.ClienteJuridico;

public class ClienteDAO implements DAO {

	private EntityManager em;

	public ClienteDAO() {
		this.em =  ConnectionFactory.Conectar();
	}

	public void Cadastrar(Object obj) {
		Cliente c = (Cliente) obj;
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
	}

	public void Listar() {
		String jpql = "SELECT c FROM Cliente c ";
		List<Cliente> resultList = this.em.createQuery(jpql, Cliente.class).getResultList();
		System.out.println(resultList.toString());
	}

	public void Alterar(int id, char escolha, String nomeCliente, String email, String endereco, String bairro,
			String estado, String telefone) {

		Cliente cliente = this.em.find(Cliente.class, id);
		this.em.merge(cliente);
		cliente.setNome(nomeCliente);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setBairro(bairro);
		cliente.setEstado(estado);
		if(cliente instanceof ClienteFisico) {
			ClienteFisico clientef = (ClienteFisico) cliente;
			clientef.setTelefonePessoal(telefone);
			this.em.persist(clientef);
		}else {
			ClienteJuridico clientej = (ClienteJuridico) cliente;
			clientej.setTelefoneComecial(telefone);
			this.em.persist(clientej);
		}
	}

	public void Deletar(int id) {
		Cliente cliente = this.em.find(Cliente.class, id);
		this.em.getTransaction().begin();
		this.em.remove(cliente);
		this.em.getTransaction().commit();
	}

	public Cliente ProcuraCPF(String cpf) {
		String jpql = "SELECT c FROM Cliente c JOIN ClienteFisico cf "
				+ "on c.id = cf.id"
				+ " WHERE cf.cpf = :cpf";
		Cliente cliente = this.em.createQuery(jpql, Cliente.class)
		.setParameter("cpf", cpf).getSingleResult();
		if(cliente != null) {
			return cliente;
		}
		throw new LojaFerramentasException("Não existe o cliente");
	}

	public Cliente ProcuraCNPJ(String cnpj) {
		String jpql = "SELECT c FROM Cliente c JOIN Cliente_Jurídico cj "
				+ "WHERE cj.cnpj = :cnpj";
		ClienteJuridico clienteJuridico = this.em.createQuery(jpql, ClienteJuridico.class)
		.setParameter("cnpj", cnpj).getSingleResult();
		if(clienteJuridico != null) {
			return clienteJuridico;
		}
		throw new LojaFerramentasException("Não existe cliente");
	}



}
