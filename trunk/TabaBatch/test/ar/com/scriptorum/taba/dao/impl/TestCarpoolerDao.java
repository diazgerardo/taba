package ar.com.scriptorum.taba.dao.impl;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com.scriptorum.taba.beans.Carpooler;

/**
 * 
 */
public class TestCarpoolerDao
{

	@Before
	public void testCreate() {
		Carpooler carpooler = new Carpooler();
		carpooler.setNombre("aaa");
		carpooler.setDni("123456");
		carpooler.setTelefono("456 789");
		CarpoolerDaoImpl pdi = CarpoolerDaoImpl.getInstance();
		assertTrue(pdi.create(carpooler, true));
	}
	
	@Test
	public void testFindByName() {
	
		CarpoolerDaoImpl pdi = CarpoolerDaoImpl.getInstance();
		List<Carpooler> list = pdi.findByName("aaa");
		for(Carpooler p: list) {
			assertTrue(p != null);
			assertTrue(pdi.delete(p));
		}
		
	}
	
	public static void main(String args[]) {
		try {

			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			transaction.begin();
			Carpooler carpooler = new Carpooler();
			carpooler.setNombre("KamalHasan");
			session.save(carpooler);
			transaction.commit();
			session.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
}
