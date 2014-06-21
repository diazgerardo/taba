package ar.com.scriptorum.dao;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.scriptorum.beans.Carpooler;
import ar.com.scriptorum.beans.Group;
import ar.com.scriptorum.beans.GroupMember;
import ar.com.scriptorum.beans.Vehiculo;

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
	
	String carpooler1 = "aaa";
	String carpooler2 = "bbb";

	@Before
	public void createCooperativeEntities() {
        
	    Carpooler carpooler = new Carpooler();
        carpooler.setNombre(carpooler1);
        carpooler.setDni("123456");
        carpooler.setTelefono("456 789");
        carpoolerDao.save(carpooler);
        
        carpooler = new Carpooler();
        carpooler.setNombre(carpooler2);
        carpooler.setDni("765432");
        carpooler.setTelefono("987 654");
        carpoolerDao.save(carpooler);
        
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setAlta(new Date());
        vehiculo.setPatente("BXG983");
		vehiculo.setPlazas(4);
		vehiculoDao.save(vehiculo);
		
	}
	
	
	@Test
	public void createGroupAndGroupMembers() {
        Group group = new Group();
        Set<GroupMember> members = new HashSet<GroupMember>();
        group.setCreacion(new Date());
        group.setNombre("testable");
        group.setGroupMembers(members);

        Carpooler c1 = carpoolerDao.findAllByProperty("nombre", carpooler1).get(1);
        Carpooler c2 = carpoolerDao.findAllByProperty("nombre", carpooler2).get(1);
	    GroupMember gm1 = new GroupMember();
        gm1.setCarpooler(c1);
        gm1.setGroup(group);
        group.getGroupMembers().add(gm1);
        
        GroupMember gm2 = new GroupMember();
        gm2.setCarpooler(c2);
        gm2.setGroup(group);
        group.getGroupMembers().add(gm2);
        
        groupDao.save(group);
        
	}
	
}
