package ar.com.scriptorum.dao;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.scriptorum.beans.Carpooler;
import ar.com.scriptorum.beans.Viaje;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:appContext.xml")
public class DaoTest
{
	
	@Autowired
	ViajeDao viajeDao;
	@Autowired
	CarpoolerDao carpoolerDao;
	@Autowired
	ItinerarioDao itinerarioDao;
	@Autowired
	GroupDao groupDao;
	@Autowired
	VehiculoDao vehiculoDao;


	@Test
	public void testCreate() {
		Carpooler carpooler = new Carpooler();
		carpooler.setNombre("aaa");
		carpooler.setDni("123456");
		carpooler.setTelefono("456 789");
		carpoolerDao.save(carpooler);
	}
	
	@Test
	public void testFindByProperty() {
	
		List<Carpooler> list = carpoolerDao.findAllByProperty("nombre", "aaa");
		for(Carpooler p: list) {
			assertTrue(p != null);
			carpoolerDao.delete(p);
		}
		
	}
	
	@Test
	public void findAllViajes() {
	
		List<Viaje> list = viajeDao.findAll();
		for(Viaje p: list) {
			assertTrue(p != null);
		}
		
	}
	
}
