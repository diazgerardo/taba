package ar.com.scriptorum.dao;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import ar.com.scriptorum.beans.Carpooler;
import ar.com.scriptorum.beans.Viaje;

/**
 * 
 */
public class DaoTest
{

	@Test
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
	
	@Test
	public void findAllViajes() {
		ViajeDaoImpl pdi = ViajeDaoImpl.getInstance();
		List<Viaje> list = pdi.findAll();
		for(Viaje p: list) {
			assertTrue(p != null);
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
