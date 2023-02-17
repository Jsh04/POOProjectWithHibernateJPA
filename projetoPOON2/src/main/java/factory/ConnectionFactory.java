package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	public static EntityManager Conectar() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoPOO");
		
		return factory.createEntityManager();
	}
}
