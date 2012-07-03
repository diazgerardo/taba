package ar.com.scriptorum.taba.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ar.com.scriptorum.taba.beans.Person;

/**
 * 
 * source : www.javabeat.net
 */
public class TestPersonDao
{
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