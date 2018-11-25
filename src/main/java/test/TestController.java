package test;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class TestController {
	
	@PersistenceUnit(unitName="testdb")
	EntityManagerFactory emf;
	EntityManager em;

	@PostConstruct
	public void init() {
		em = emf.createEntityManager();
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public void index() {
		em.getTransaction().begin();
		TestComponent tc = new TestComponent();
		tc.setValue("test");
		em.persist(tc);
		em.getTransaction().commit();
		
	}
}
