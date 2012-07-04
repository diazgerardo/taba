package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import ar.com.scriptorum.taba.beans.Person;

/**
 * 
 */
public class TestPersonDao
{

	@Test
	public void testFindByName() {
	
		PersonDaoImpl<Person> pdi = new PersonDaoImpl<Person>(new Person());
		Person p = pdi.findByName("aaa");
		assertTrue(p != null);
		
	}
	
	@Test
	public void testDelete() {
	
		PersonDaoImpl<Person> pdi = new PersonDaoImpl<Person>(new Person());
		Person p = pdi.findByName("aaa");
		assertTrue(pdi.delete(p));
		
	}
	
	public static void main(String args[]) {
		try {

			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			transaction.begin();
			Person person = new Person();
			person.setName("KamalHasan");
			session.save(person);
			transaction.commit();
			session.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
}
