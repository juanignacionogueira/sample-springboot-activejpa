package momentous.resto;

import javax.persistence.EntityManagerFactory;

import org.activejpa.enhancer.ActiveJpaAgentLoader;
import org.activejpa.jpa.JPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestoApplication {

	public static void main(String[] args) {

		// Loads the Java agent dynamically

		// Add the persistence unit defined by persistence.xml identified by the
		// name 'order'. The persistence.xml should be available in the
		// classpath
		// JPA.addPersistenceUnit("order");

		// If you have entity manager factory already created, you can attach
		// the same to ActiveJpa
		// JPA.addPersistenceUnit("order", entityManagerFactory);

		ActiveJpaAgentLoader.instance().loadAgent();
		ApplicationContext ctx = SpringApplication.run(RestoApplication.class, args);

		// super.contextInitialized(event);

		EntityManagerFactory entityManagerFactory = ctx.getBean(EntityManagerFactory.class);
		JPA.instance.addPersistenceUnit("default", entityManagerFactory, true);

	}

}
