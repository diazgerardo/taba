package ar.com.scriptorum.taba.dao.impl;


import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.scriptorum.taba.beans.Person;

/**
 * 
 */
public class TestPersonDao
{

	@Before
	public void testCreate() {
		Person person = new Person();
		person.setName("aaa");
		PersonDaoImpl pdi = PersonDaoImpl.getInstance();
		assertTrue(pdi.create(person, true));
	}
	
	@Test
	public void testFindByName() {
	
		PersonDaoImpl pdi = PersonDaoImpl.getInstance();
		Person p = pdi.findByName("aaa");
		assertTrue(p != null);
		
	}
	
	@After
	public void testDelete() {
	
		PersonDaoImpl pdi = PersonDaoImpl.getInstance();
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
